package by.subota.max.dao.impl;

import by.subota.max.dao.AbstractJdbcDao;
import by.subota.max.dao.GenericDao;
import by.subota.max.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Example User DAO implementation
 */
public class UserDaoImpl extends AbstractJdbcDao<User, Integer> implements GenericDao<User, Integer> {

    @Override
    protected List<User> parseResultSet(ResultSet rs) throws SQLException {

        throw new UnsupportedOperationException();
    }

    @Override
    protected void prepareStatementForInsert(PreparedStatement statement, User object) throws SQLException {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, User object) throws SQLException {

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
}
