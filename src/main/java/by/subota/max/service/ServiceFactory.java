package by.subota.max.service;

import by.subota.max.service.impl.UserServiceImpl;

/**
 * Service factory
 */
public class ServiceFactory {
    private static ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public UserService getUserService() {
        return new UserServiceImpl();
    }
}
