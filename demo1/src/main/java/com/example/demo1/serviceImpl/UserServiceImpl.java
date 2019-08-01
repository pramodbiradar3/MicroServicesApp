package com.example.demo1.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.User;
import com.example.demo1.repository.UserRepository;
import com.example.demo1.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser() {
		return userRepository.save(new User("test1","test1","password"));
	}
}
