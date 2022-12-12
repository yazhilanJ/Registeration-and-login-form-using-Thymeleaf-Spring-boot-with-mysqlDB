package com.Resgister.Register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Resgister.Register.User;
import com.Resgister.Register.dao.UserDao;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
private UserDao userdao;
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userdao.save(user);
	}
	
		
	}

	
	

