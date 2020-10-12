package com.organics.microserviceprofile.repository;

import com.organics.microserviceprofile.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
//  User update(User user);TODO
}
