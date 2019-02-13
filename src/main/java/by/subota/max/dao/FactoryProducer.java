package by.subota.max.dao;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Factory producer
 * Provide DAO Factory by type
 */
public class FactoryProducer {
    private static FactoryProducer instance;
    private static Lock lock = new ReentrantLock();
    private FactoryProducer() {}

    public static FactoryProducer getInstance() {
        lock.lock();
        try {
            if (instance == null) {
                instance = new FactoryProducer();
            }

        } finally {
            lock.unlock();
        }

        return instance;
    }

    public static DaoFactory getDaoFactory(DaoFactoryType type) {

        //provide your code here

        throw new UnsupportedOperationException();
    }
}
