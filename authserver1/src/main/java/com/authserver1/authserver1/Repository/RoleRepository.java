package com.authserver1.authserver1.Repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authserver1.authserver1.Enums.RoleEnum;
import com.authserver1.authserver1.Models.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel,UUID> {
    Optional<RoleModel> findBynome(RoleEnum roleEnum);
}
