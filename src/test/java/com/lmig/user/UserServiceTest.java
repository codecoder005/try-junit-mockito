package com.lmig.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository testUserRepository;

    private UserService userService;

    @BeforeEach
    void setup(){
        userService = new UserService(testUserRepository, null);
    }

    @Test
    void testGetUserByName() {
        // given
        Long uid = 101L;
        String email = "doe@email";
        String name = "Doe";
        UserEntity userEntity = new UserEntity(uid, name, email, null);
        given(testUserRepository.findByName(name)).willReturn(userEntity);
        given(testUserRepository.findByNameAndEmail(name, email)).willReturn(userEntity);

        // when
        UserEntity user = userService.getUserByName(name);
        UserEntity userByEmailName = userService.getUserByNameAndEmail(name, email);

        // then
        assertThat(user).isNotNull();
        assertThat(userByEmailName).isNotNull();
        assertThat(userByEmailName).isEqualTo(user);
        verify(testUserRepository).findByName(name);
        verify(testUserRepository).findByNameAndEmail(name, email);
    }
}
