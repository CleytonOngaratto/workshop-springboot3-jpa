package com.webservicespring.project.repositories;

import com.webservicespring.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
