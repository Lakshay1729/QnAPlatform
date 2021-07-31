package com.internship.QnAPlatform.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.internship.QnAPlatform.Entity.User;
import com.internship.QnAPlatform.Repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("/insert")
	public User insertUser(@RequestBody User user)
	{
		
		return userRepo.save(user);
	}

}
