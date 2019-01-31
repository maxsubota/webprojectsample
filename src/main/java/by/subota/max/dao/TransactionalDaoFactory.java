package by.subota.max.dao;

/**
 * Transactional DAO Factory
 * @param <T>
 */
public interface TransactionalDaoFactory<T> {
    /**
     * Get generic DAO of entity without connection
     * @param dtoClass
     * @param connection
     * @return
     */
    GenericDao getTransactionalDao(Class dtoClass, T connection);
}
