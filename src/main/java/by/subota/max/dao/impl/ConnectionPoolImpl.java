package by.subota.max.dao.impl;

import by.subota.max.dao.ConnectionPool;
import by.subota.max.dao.exception.ConnectionPoolException;

import java.sql.Connection;

/**
 * Implementation of Connection Pool
 */
public class ConnectionPoolImpl implements by.subota.max.dao.ConnectionPool {
    private static ConnectionPool instance;

    private ConnectionPoolImpl() {}

    public static synchronized ConnectionPool getInstance() {
        //wrong impl of singleton, it's not thread safe. Think why
        if (instance == null) {
            instance = new ConnectionPoolImpl();
        }

        return instance;
    }

    @Override
    public Connection retrieveConnection() throws ConnectionPoolException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public void putBackConnection(Connection connection) {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public void destroyPool() throws ConnectionPoolException {

        //provide your code here

        throw new UnsupportedOperationException();
    }
}
