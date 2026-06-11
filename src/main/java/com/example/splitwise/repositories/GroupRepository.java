package com.example.splitwise.repositories;

import com.example.splitwise.models.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<UserGroup , Long> {

    Optional<UserGroup> findByName(String name);
}
