package com.example.demo.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

    @Autowired private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role user = new Role("User");
        Role manager = new Role("Manager");

        repo.saveAll(List.of(user, manager));

        List<Role> listRoles = repo.findAll();

        assertThat(listRoles.size()).isEqualTo(2);
    }

}