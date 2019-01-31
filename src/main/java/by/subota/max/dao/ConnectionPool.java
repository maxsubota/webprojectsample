package by.subota.max.dao;

import by.subota.max.dao.exception.ConnectionPoolException;

import java.sql.Connection;

/**
 * Connection Pool
 */
//you can use standart pool https://commons.apache.org/proper/commons-pool/apidocs/org/apache/commons/pool2/impl/GenericObjectPool.html
public interface ConnectionPool {

    /**
     * Return connection from CP if exists
     * @return - connection from CP if exists
     * @throws ConnectionPoolException - should be clarify
     */
    Connection retrieveConnection() throws ConnectionPoolException;

    /**
     * Put back connection after using
     * @param connection - connection
     */
    //how this method is supposed to work?
    void putBackConnection(Connection connection);

    /**
     * Destroy CP. Method close all connections.
     * @throws ConnectionPoolException should be clarify
     */
    void destroyPool() throws ConnectionPoolException;
}
