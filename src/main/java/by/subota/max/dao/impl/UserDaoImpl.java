package by.subota.max.dao.impl;

import by.subota.max.dao.AbstractJdbcDao;
import by.subota.max.dao.exception.PersistException;
import by.subota.max.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Example User DAO implementation
 */
public class UserDaoImpl extends AbstractJdbcDao<User, Integer> {

    UserDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    protected List<User> parseResultSet() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws PersistException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws PersistException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws PersistException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getSelectQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getCreateQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getUpdateQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public String getDeleteQuery() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    public User create() throws PersistException {

        //provide your code here

        throw new UnsupportedOperationException();
    }
}
