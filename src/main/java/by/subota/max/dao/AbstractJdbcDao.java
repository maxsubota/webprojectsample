package by.subota.max.dao;

import by.subota.max.dao.exception.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Abstract JDBC DAO
 * @param <T> - Identified entity
 * @param <PK> - Type primary key of entity
 */
public abstract class AbstractJdbcDao<T extends Identified<PK>, PK extends Number> implements GenericDao<T, PK> {
    private Connection connection;

    protected abstract List<T> parseResultSet();

    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws PersistException;

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    //when connefction is supposed to be opened? On the first query?

    public AbstractJdbcDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public T getByPK(PK key) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> getAll() throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public T persist(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public void update(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }
}
