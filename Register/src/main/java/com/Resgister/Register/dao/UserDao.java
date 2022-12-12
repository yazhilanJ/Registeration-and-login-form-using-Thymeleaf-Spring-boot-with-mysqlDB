package com.Resgister.Register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Resgister.Register.User;
@Repository
public interface UserDao extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByPassword(String password);

}
