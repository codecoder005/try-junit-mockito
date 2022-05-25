package com.lmig.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserController {
    @NonNull
    private final UserService userService;

    public UserEntity getUserByName(String name) {
        return userService.getUserByName(name);
    }
}
