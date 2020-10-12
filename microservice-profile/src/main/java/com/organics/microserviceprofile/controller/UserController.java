package com.organics.microserviceprofile.controller;

import com.organics.microserviceprofile.exception.UserNotFoundException;
import com.organics.microserviceprofile.model.User;
import com.organics.microserviceprofile.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/profile")
public class UserController {

  private final IUserService service;

  private static final Logger log = LogManager.getLogger(UserController.class);

  public UserController(IUserService service) {
    this.service = service;
  }

  @GetMapping(path = "/{userId}")
  public @ResponseBody
  User getUser(@PathVariable("userId") int userId) {
    log.debug("Getting the user for id: " + userId);
    return service.getUser(userId);
  }

  @GetMapping(path = "/")
  public @ResponseBody
  Iterable<User> getAllUsers() {
    log.debug("Getting all the users");
    return service.getAllUsers();
  }

  @PostMapping(path = "/add")
  public @ResponseBody
  User addNewUser(@RequestBody User user) {
    log.debug("Adding new user: " + user.getName());
    return service.save(user);
  }

  @PutMapping(path = "/")
  public @ResponseBody
  User updateUser(@RequestBody User user) {
    log.debug("Updating the user for userId: " + user.getId());
    return service.update(user);
  }

  @DeleteMapping(path = "/{userId}")
  public @ResponseBody
  void deleteUser(@PathVariable("userId") int userId) {
    log.debug("Deleting the user for id: " + userId);
    service.remove(userId);
  }


}
