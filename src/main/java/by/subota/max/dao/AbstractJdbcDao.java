package by.subota.max.dao;

import by.subota.max.dao.exception.DaoException;
import by.subota.max.dao.exception.PersistException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Abstract JDBC DAO
 * @param <T> - Identified entity
 * @param <PK> - Type primary key of entity
 */
public abstract class AbstractJdbcDao<T extends Identified<PK>, PK extends Number> implements GenericDao<T, PK> {
    protected Connection connection;

    protected abstract List<T> parseResultSet(ResultSet rs) throws SQLException;

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws SQLException;

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object) throws SQLException;

    public abstract String getSelectQuery();

    public abstract String getCreateQuery();

    public abstract String getUpdateQuery();

    public abstract String getDeleteQuery();

    @Override
    @AutoConnection
    public T getByPK(PK key) throws DaoException {

        // Write your code here

        return null;
    }

    @Override
    @AutoConnection
    public List<T> getAll() throws DaoException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    @AutoConnection
    public T persist(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    @AutoConnection
    public void update(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    @Override
    @AutoConnection
    public void delete(T object) throws PersistException {

        // Write your code here

        throw new UnsupportedOperationException();
    }

    void setConnection(Connection connection) {
        this.connection = connection;
    }
}
