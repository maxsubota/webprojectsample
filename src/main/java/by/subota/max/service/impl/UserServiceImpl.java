package by.subota.max.service.impl;

import by.subota.max.dao.DaoFactory;
import by.subota.max.dao.DaoFactoryType;
import by.subota.max.dao.FactoryProducer;
import by.subota.max.dao.GenericDao;
import by.subota.max.dao.exception.DaoException;
import by.subota.max.dao.exception.PersistException;
import by.subota.max.domain.User;
import by.subota.max.service.UserService;
import by.subota.max.service.exception.ServiceException;

/**
 * Example of user service implementation
 */
public class UserServiceImpl implements UserService {
    @Override
    public User signUp(User user) throws ServiceException {
        DaoFactory daoFactory = FactoryProducer.getDaoFactory(DaoFactoryType.JDBC);

        //provide your code here

        try {
            GenericDao<User, Integer> userDao = daoFactory.getDao(User.class);
            userDao.persist(user);

        } catch (DaoException e) {
            throw new ServiceException("Failed to get user DAO. ", e);

        } catch (PersistException e) {
            throw new ServiceException("Failed to save user. ", e);
        }

        //provide your code here

        throw new UnsupportedOperationException();
    }
}
