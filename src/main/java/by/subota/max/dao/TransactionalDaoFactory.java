package by.subota.max.dao;

import by.subota.max.dao.exception.DaoException;

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
     * @throws DaoException should be clarify
     */
    GenericDao getTransactionalDao(Class dtoClass, T connection) throws DaoException;
}
