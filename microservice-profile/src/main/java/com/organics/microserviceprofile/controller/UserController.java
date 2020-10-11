package com.organics.microserviceprofile.controller;

import com.organics.microserviceprofile.exception.UserNotFound;
import com.organics.microserviceprofile.model.User;
import com.organics.microserviceprofile.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

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
  User getUser(@PathVariable("userId") int userId) throws UserNotFound {
    log.debug("Get the user for id: " + userId);
    return service.getUser(userId);
  }

  @GetMapping(path = "/all")
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

}
