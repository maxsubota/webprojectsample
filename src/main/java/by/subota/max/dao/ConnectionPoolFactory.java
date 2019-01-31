package by.subota.max.dao;

import by.subota.max.dao.impl.ConnectionPoolImpl;

/**
 * Connection Pool Factory
 */
//you can use standart pool factory from apache.commons, it has a number of advantages over own impl - https://commons.apache.org/proper/commons-pool/apidocs/org/apache/commons/pool2/PooledObjectFactory.html
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
