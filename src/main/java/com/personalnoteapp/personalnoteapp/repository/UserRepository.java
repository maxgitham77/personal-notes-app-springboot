package com.personalnoteapp.personalnoteapp.repository;

import com.personalnoteapp.personalnoteapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
