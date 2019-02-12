package by.subota.max.dao.impl;

import by.subota.max.dao.AbstractJdbcDao;
import by.subota.max.dao.ConnectionPool;
import by.subota.max.dao.ConnectionPoolFactory;
import by.subota.max.dao.GenericDao;
import by.subota.max.dao.exception.ConnectionPoolException;
import by.subota.max.dao.exception.DaoException;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * Implementation of transaction with DAO
 */
public final class TransactionManager {
    private Connection proxyConnection;

    public void begin(GenericDao dao, GenericDao ... daos) throws DaoException {

        ConnectionPool connectionPool = ConnectionPoolFactory.getInstance().getConnectionPool();

        try {
            proxyConnection = connectionPool.retrieveConnection();
            setConnectionWithReflection(dao, proxyConnection);

        } catch (ConnectionPoolException e) {
            throw new DaoException("Failed to get a connection from CP.", e);
        }

        //provide your code here

        throw new UnsupportedOperationException();
    }

    public void end() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    public void commit() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    public void rollback() {

        //provide your code here

        throw new UnsupportedOperationException();
    }


    static void setConnectionWithReflection(Object dao, Connection connection) throws DaoException {
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
