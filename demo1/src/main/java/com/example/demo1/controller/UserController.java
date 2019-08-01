package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.User;
import com.example.demo1.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/saveUser", method = RequestMethod.GET)
	public User saveUser(){
		return userService.saveUser();
	}
}
