package com.anmlmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anmlmanagement.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
 public User findByUsername(String username);

}
