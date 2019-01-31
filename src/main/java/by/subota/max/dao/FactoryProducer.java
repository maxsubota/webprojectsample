package by.subota.max.dao;

/**
 * Factory producer
 * Provide DAO Factory by type
 */
public class FactoryProducer {
    private static volatile FactoryProducer instance;
    private FactoryProducer() {}

    public FactoryProducer getInstance() {
        if (instance == null) {
            synchronized (FactoryProducer.class) {
                if (instance == null) {
                    instance = new FactoryProducer();
                }
            }
        }
        return instance;
    }

    public static DaoFactory getDaoFactory(DaoFactoryType type) {

        //provide your code here

        throw new UnsupportedOperationException();
    }
}
