package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Test
    public void testAddRoleToNewUser() {

        User user = new User();
        user.setEmail("jefftom@gmail.com");
        user.setPassword("password");
        user.setFirstName("Jeff");
        user.setLastName("Tom");

        Role roleUser = roleRepo.findByName("User");
        //user.addRole(roleUser);

        User savedUser = userRepo.save(user);

        //assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }
}
