package com.organics.microserviceprofile.controller;

import com.organics.microserviceprofile.model.User;
import com.organics.microserviceprofile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/profile")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping(path="/add")
  public @ResponseBody String addNewUser (@RequestBody User user) {
    User n = user;
    userRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    return userRepository.findAll();
  }
}
