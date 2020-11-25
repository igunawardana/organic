package com.organics.ms.profile.service;

import com.organics.ms.profile.exception.UserNotFoundException;
import com.organics.ms.profile.model.User;
import com.organics.ms.profile.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

  private final com.organics.ms.profile.repository.IUserRepository IUserRepository;

  public UserServiceImpl(IUserRepository IUserRepository) {
    this.IUserRepository = IUserRepository;
  }

  @Override
  public User getUser(int userId) throws UserNotFoundException {
    return IUserRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("No matching user for user id = " + userId));
  }

  @Override
  public Iterable<User> getAllUsers() {
    return IUserRepository.findAll();
  }

  @Override
  public User save(User user) {
    return IUserRepository.save(user);
  }

  @Override
  public void remove(int userId) throws UserNotFoundException {
    try {
      IUserRepository.deleteById(userId);
    } catch (Exception e) {
      throw new UserNotFoundException("Error in removing user with userId = " + userId, e);
    }
  }

  @Override
  public User update(User user) throws UserNotFoundException {
    return IUserRepository.save(user);
    //TODO use update implementation
    //TODO test user not found exception
  }
}
