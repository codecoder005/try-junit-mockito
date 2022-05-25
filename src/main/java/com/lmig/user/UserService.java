package com.lmig.user;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @NonNull
    private final UserRepository userRepository;
    @NonNull
    private final OrderRepository orderRepository;

    public UserEntity getUserByName(String name) {
        if(shouldICall()) {
            return userRepository.findByName(name);
        }
        return null;
    }
    public boolean shouldICall(){
        return true;
    }

    public UserEntity getUserByNameAndEmail(String name, String email) {
        if(shouldICall()) {
            return userRepository.findByNameAndEmail(name, email);
        }
        return null;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterAppIsReady(){
        System.out.println("UserService.afterAppIsReady()");
        userRepository.save(
                UserEntity.builder()
                        .uid(101L)
                        .name("John")
                        .email("john@email")
                        .placedOrders(
                                List.of(
                                        OrderEntity.builder()
                                                .oid(1L)
                                                .amount(100.00d)
                                                .user(UserEntity.builder().uid(101L).build())
                                                .build()
                                )
                        )
                        .build()
        );
        System.out.println(userRepository.findById(101L).get());
        System.out.println(orderRepository.getUserOrderRow(101L, 1L));
    }
}
