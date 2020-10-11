package com.organics.microserviceprofile.service;

import com.organics.microserviceprofile.exception.UserNotFound;
import com.organics.microserviceprofile.model.User;
import com.organics.microserviceprofile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User getUser(int userId) throws UserNotFound {
    return userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFound("No matching user for user id: " + userId));
  }

  @Override
  public Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }
}
