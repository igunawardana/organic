package com.organics.microserviceprofile.repository;

import com.organics.microserviceprofile.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User , Integer> {
}
