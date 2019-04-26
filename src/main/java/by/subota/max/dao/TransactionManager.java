package by.subota.max.dao;


import by.subota.max.dao.exception.ConnectionPoolException;
import by.subota.max.dao.exception.DaoException;

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

            ((AbstractJdbcDao)dao).setConnection(proxyConnection);

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
}
