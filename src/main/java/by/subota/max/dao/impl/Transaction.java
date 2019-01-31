package by.subota.max.dao.impl;

import by.subota.max.dao.GenericDao;

import java.sql.Connection;

/**
 * Implementation of transaction with DAO
 */
//these methods here should throw exceptions
    //add some config methods like setAutoCommit, setRollbackOnly. They can be added to some e.g. TransactionManager
public final class Transaction {
    private Connection connection;

//commit and rollback methods are necessary, not sure about the others
    public void begin(GenericDao dao, GenericDao ... daos) {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    //what this method is supposed to do?
    public void end() {

        //provide your code here

        throw new UnsupportedOperationException();
    }


    public void commit() {

        //provide your code here

        throw new UnsupportedOperationException();
    }

    public void rollback() {

        //provide your code here

        throw new UnsupportedOperationException();
    }


}
