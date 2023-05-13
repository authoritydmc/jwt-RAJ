package com.rajdubey.jwtRAJ.repos;

import com.rajdubey.jwtRAJ.entites.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(String name);

}
