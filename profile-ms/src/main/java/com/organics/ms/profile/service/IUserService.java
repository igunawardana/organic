package com.organics.ms.profile.service;

import com.organics.ms.profile.exception.UserNotFoundException;
import com.organics.ms.profile.model.User;

public interface IUserService {

  User getUser(int userId) throws UserNotFoundException;

  Iterable<User> getAllUsers();

  User save(User user);

  User update(User user) throws UserNotFoundException;

  void remove(int userId) throws UserNotFoundException;

}
