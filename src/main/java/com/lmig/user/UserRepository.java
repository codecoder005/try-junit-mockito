package com.lmig.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByName(String name);
    UserEntity findByEmail(String email);
    UserEntity findByNameAndEmail(String name, String email);
}
