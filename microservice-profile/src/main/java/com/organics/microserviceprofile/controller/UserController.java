package com.organics.microserviceprofile.controller;

import com.organics.microserviceprofile.exception.UserNotFoundException;
import com.organics.microserviceprofile.model.User;
import com.organics.microserviceprofile.service.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  ResponseEntity<User> getUser(@PathVariable("userId") int userId) {
    log.debug("Getting the user for id: " + userId);
    try {
      return new ResponseEntity(service.getUser(userId), HttpStatus.OK);
    } catch (UserNotFoundException e) {
      log.error("Error in retrieving the user. ", e);
      return new ResponseEntity("Error in retrieving the user.", HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      log.error("Error in retrieving the user. ", e);
      return new ResponseEntity("Error in retrieving the user.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping(path = "/")
  public @ResponseBody
  ResponseEntity<Iterable<User>> getAllUsers() {
    log.debug("Getting all the users");
    try {
      return new ResponseEntity(service.getAllUsers(), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in retrieving the user list. ", e);
      return new ResponseEntity("Error in retrieving the user list.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(path = "/add")
  public @ResponseBody
  ResponseEntity<User> addNewUser(@RequestBody User user) {
    log.debug("Adding new user: " + user.getName());
    try {
      return new ResponseEntity<User>(service.save(user), HttpStatus.CREATED);
    } catch (Exception e) {
      log.error("Error in creating the user. ", e);
      return new ResponseEntity("Error in creating the user.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping(path = "/")
  public @ResponseBody
  ResponseEntity<User> updateUser(@RequestBody User user) {
    try {
      log.debug("Updating the user for userId: " + user.getId());
      return new ResponseEntity<User>(service.update(user), HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in updating the user. ", e);
      return new ResponseEntity("Error in updating the user.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping(path = "/{userId}")
  public @ResponseBody
  ResponseEntity deleteUser(@PathVariable("userId") int userId) {
    log.debug("Deleting the user for id: " + userId);
    try {
      service.remove(userId);
      return new ResponseEntity("User Deleted Successfully.", HttpStatus.OK);
    } catch (Exception e) {
      log.error("Error in deleting the user. ", e);
      return new ResponseEntity("Error in deleting the user.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
