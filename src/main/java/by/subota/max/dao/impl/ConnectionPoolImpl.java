package by.subota.max.dao.impl;

import by.subota.max.dao.ConnectionPool;
import by.subota.max.dao.exception.ConnectionPoolException;

import java.sql.Connection;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementation of Connection Pool
 */
public class ConnectionPoolImpl implements ConnectionPool {
    private static ConnectionPool instance;
    private static Lock lock = new ReentrantLock();

    private ConnectionPoolImpl() {}

    public static ConnectionPool getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new ConnectionPoolImpl();
            }

        } finally {
            lock.unlock();
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
