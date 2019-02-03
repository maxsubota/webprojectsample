package by.subota.max.dao.impl;

import by.subota.max.dao.DaoFactory;
import by.subota.max.dao.TransactionalDaoFactory;
import by.subota.max.dao.GenericDao;
import by.subota.max.dao.ConnectionPool;
import by.subota.max.dao.ConnectionPoolFactory;
import by.subota.max.dao.AbstractJdbcDao;
import by.subota.max.dao.exception.DaoException;
import by.subota.max.domain.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Jdbc DAO Factory
 */
public class JdbcDaoFactory implements DaoFactory, TransactionalDaoFactory<Connection> {
    private static volatile JdbcDaoFactory instance;
    private Map<Class, Supplier<GenericDao>> creators = new HashMap<>();

    private class DaoInvocationHandler implements InvocationHandler {
        private GenericDao dao;

        DaoInvocationHandler(GenericDao dao) {
            this.dao = dao;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();
            Connection connection = connectionPool.retrieveConnection();

            setConnectionWithReflection(dao, connection);

            Object result = method.invoke(dao, args);

            connectionPool.putBackConnection(connection);
            setConnectionWithReflection(dao, null);

            return result;
        }

    }

    private JdbcDaoFactory() {
        creators.put(User.class, UserDaoImpl::new);
    }

    public static JdbcDaoFactory getInstance() {
        if (instance == null) {
            synchronized (JdbcDaoFactory.class) {
                if (instance == null) {
                    instance = new JdbcDaoFactory();
                }
            }
        }

        return instance;
    }

    @Override
    public GenericDao getDao(Class entityClass) throws DaoException {
        Supplier<GenericDao> daoCreator = creators.get(entityClass);
        if (daoCreator == null) {
            throw new DaoException("Entity Class cannot be find");
        }
        GenericDao dao = daoCreator.get();

        return (GenericDao) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                dao.getClass().getInterfaces(),
                new DaoInvocationHandler(dao));
    }

    @Override
    public GenericDao getTransactionalDao(Class entityClass, Connection connection) throws DaoException {
        Supplier<GenericDao> daoCreator = creators.get(entityClass);
        if (daoCreator == null) {
            throw new DaoException("Entity Class cannot be find");
        }
        GenericDao dao = daoCreator.get();

        setConnectionWithReflection(dao, connection);

        return dao;
    }

    private void setConnectionWithReflection(Object dao, Connection connection) throws DaoException {
        if (!(dao instanceof AbstractJdbcDao)) {
            throw new DaoException("DAO implementation does not extend AbstractJdbcDao.");
        }

        try {
            Field connectionField = AbstractJdbcDao.class.getDeclaredField("connection");
            if (!connectionField.isAccessible()) {
                connectionField.setAccessible(true);
            }
            connectionField.set(dao, connection);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new DaoException("Failed to set connection for transactional DAO. ", e);
        }
    }
}
