package com.duranty.rentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.duranty.rentapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
