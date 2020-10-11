package com.organics.microserviceprofile.service;

import com.organics.microserviceprofile.exception.UserNotFound;
import com.organics.microserviceprofile.model.User;

public interface IUserService {

  User getUser(int userId) throws UserNotFound;

  Iterable<User> getAllUsers();

  User save(User user);

}
