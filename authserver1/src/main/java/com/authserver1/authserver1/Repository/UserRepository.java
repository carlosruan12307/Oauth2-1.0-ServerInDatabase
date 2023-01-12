package com.authserver1.authserver1.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.authserver1.authserver1.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel,UUID> {
    
    Optional<UserModel> findBynome(String nome);
}
