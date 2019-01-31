package by.subota.max.dao;

import by.subota.max.dao.impl.ConnectionPoolImpl;

/**
 * Connection Pool Factory
 */
public class ConnectionPoolFactory {
    private static volatile ConnectionPoolFactory instance;

    private ConnectionPoolFactory() {}

    public static ConnectionPoolFactory getInstance() {
        if (instance == null) {
            synchronized (ConnectionPoolFactory.class) {
                if (instance == null) {
                    instance = new ConnectionPoolFactory();
                }
            }
        }

        return instance;
    }

    public ConnectionPool getConnectionPool() {
        return ConnectionPoolImpl.getInstance();
    }
}
