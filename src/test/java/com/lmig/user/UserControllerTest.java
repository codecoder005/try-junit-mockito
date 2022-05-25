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
class UserControllerTest {
    @Mock
    private UserService userService;

    private UserController userController;

    @BeforeEach
    public void setup() {
        userController = new UserController(userService);
    }

    @Test
    public void testGetUserByName() {
        // given
        Long uid = 101L;
        String email = "doe@email";
        String name = "Doe";
        UserEntity userEntity = new UserEntity(uid, name, email, null);
        given(userService.getUserByName(name)).willReturn(userEntity);

        // when
        UserEntity user = userController.getUserByName(name);

        // then
        assertThat(user).isNotNull();
        verify(userService).getUserByName(name);
    }
}