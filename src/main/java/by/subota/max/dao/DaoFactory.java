package by.subota.max.dao;

import by.subota.max.dao.exception.DaoException;

/**
 * Dao Factory
 */
public interface DaoFactory {
    /**
     * Return implementation of DAO for entity class
     * @param dtoClass - entity class
     * @return - implementation of DAO for entity class
     * @throws DaoException - should be clarify
     */
    GenericDao getDao(Class dtoClass) throws DaoException;
}
