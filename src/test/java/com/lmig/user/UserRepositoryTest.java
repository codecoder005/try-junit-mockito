package com.lmig.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void setup(){
        assertNotNull(userRepository);
    }

    @Test
    public void testFindByName(){
        Long uid = 101L;
        String name = "John";
        String email = "john@email";
        UserEntity actualUser = new UserEntity(uid, name, email);
        userRepository.save(actualUser);

        UserEntity responseUser = userRepository.findByName("John");
        assertNotNull(responseUser);
        assertEquals(uid, responseUser.getUid());
        assertEquals(name, responseUser.getName());
        assertEquals(email, responseUser.getEmail());
    }

    @Test
    public void testFindByEmail(){
        Long uid = 101L;
        String name = "John";
        String email = "john@email";
        UserEntity actualUser = new UserEntity(uid, name, email);
        userRepository.save(actualUser);

        UserEntity responseUser = userRepository.findByEmail(email);
        assertNotNull(responseUser);
        assertEquals(uid, responseUser.getUid());
        assertEquals(name, responseUser.getName());
        assertEquals(email, responseUser.getEmail());
    }

    @Test
    public void testFindByEmailAndName(){
        Long uid = 101L;
        String name = "John";
        String email = "john@email";
        UserEntity actualUser = new UserEntity(uid, name, email);
        userRepository.save(actualUser);

        UserEntity responseUser = userRepository.findByNameAndEmail(name, email);
        assertNotNull(responseUser);
        assertEquals(uid, responseUser.getUid());
        assertEquals(name, responseUser.getName());
        assertEquals(email, responseUser.getEmail());
    }
}
