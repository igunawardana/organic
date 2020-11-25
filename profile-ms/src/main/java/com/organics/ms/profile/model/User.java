package com.organics.ms.profile.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class User {

  @Id
  @SequenceGenerator(name = "USER_SEQ", sequenceName = "user_sequence")
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "USER_SEQ")
  private Integer id;
  private String name;
  private String email;
  private Role role;

  public User() {
  }

  public User(String name, String email, Role role) {
    this.name = name;
    this.email = email;
    this.role = role;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
