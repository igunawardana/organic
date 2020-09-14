package com.organics.microserviceprofile.repository;

import com.organics.microserviceprofile.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends CrudRepository<User , Integer> {
}
