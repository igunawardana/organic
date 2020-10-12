package com.organics.microserviceprofile.service;

import com.organics.microserviceprofile.exception.UserNotFoundException;
import com.organics.microserviceprofile.model.User;

public interface IUserService {

  User getUser(int userId) throws UserNotFoundException;

  Iterable<User> getAllUsers();

  User save(User user);

  User update(User user) throws UserNotFoundException;

  void remove(int userId) throws UserNotFoundException;

}
