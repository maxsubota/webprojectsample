package by.subota.max.dao.impl;

import by.subota.max.dao.DaoFactory;
import by.subota.max.dao.TransactionalDaoFactory;
import by.subota.max.dao.GenericDao;
import by.subota.max.dao.ConnectionPool;
import by.subota.max.dao.ConnectionPoolFactory;
import by.subota.max.dao.exception.ConnectionPoolException;
import by.subota.max.dao.exception.DaoException;
import by.subota.max.domain.User;

import java.sql.Connection;
import java.util.Map;
import java.util.function.Function;

/**
 * Jdbc DAO Factory
 */
public class JdbcDaoFactory implements DaoFactory, TransactionalDaoFactory<Connection> {
    private static volatile JdbcDaoFactory instance;
    private Map<Class, Function<Connection, GenericDao>> creators;

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
    public GenericDao getDao(Class dtoClass) throws DaoException {
        try {
            ConnectionPool connectionPool = ConnectionPoolFactory.getInstance()
                    .getConnectionPool();

            return creators.get(dtoClass)
                    .apply(connectionPool.retrieveConnection());

        } catch (ConnectionPoolException e) {
            throw new DaoException("Failed to retrieve MySQL connection from ConnectionPoolImpl. ", e);
        }
    }

    @Override
    public GenericDao getTransactionalDao(Class dtoClass, Connection connection) {
        return creators.get(dtoClass)
                .apply(connection);
    }
}
