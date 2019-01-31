package by.subota.max.service;

import by.subota.max.domain.User;
import by.subota.max.service.exception.ServiceException;

public interface UserService {

    User signUp(User user) throws ServiceException;

    // Provide your code here

}
