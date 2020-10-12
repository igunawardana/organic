package com.organics.microserviceprofile.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.organics.microserviceprofile.model.User;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class IUserRepositoryTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private IUserRepository repository;

    @Test
    void testAddUser() throws Exception {
        this.entityManager.persist(new User("TestUser", "test@test.com", "SE"));
        Optional<User> user = this.repository.findById(1);
        assertThat(user.get().getName()).isEqualTo("TestUser");
        assertThat(user.get().getEmail()).isEqualTo("test@test.com");
    }
}