package by.subota.max.dao;

import by.subota.max.dao.exception.DaoException;
import by.subota.max.dao.exception.PersistException;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO
 * @param <T> - Identified entity
 * @param <PK> - Entity primary key
 */
public interface GenericDao<T extends Identified<PK>, PK extends Serializable> {
    /**
     * Save identified entity in DB
     * @param object identified entity
     * @return identified entity in DB
     * @throws PersistException should be clarify
     */
    T persist(T object) throws PersistException;

    /**
     * Get identified entity by PK
     * @param id id
     * @return identified entity
     * @throws DaoException should be clarify
     */
    T getByPK(PK id) throws DaoException;

    /**
     * Update identified entity
     * @param object identified entity
     * @throws PersistException should be clarify
     */
    void update(T object) throws PersistException;

    /**
     * Delete identified entity
     * @param object identified entity
     * @throws PersistException should be clarify
     */
    void delete(T object) throws PersistException;

    /**
     * Get all identified entity
     * @return identified entity
     * @throws DaoException should be clarify
     */
    List<T> getAll() throws DaoException;
}
