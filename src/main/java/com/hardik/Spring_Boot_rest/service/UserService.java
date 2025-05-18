package com.hardik.Spring_Boot_rest.service;


import com.hardik.Spring_Boot_rest.model.User;
import com.hardik.Spring_Boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;
	private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12); // or we can can create a bean of this in security config file
	
	public User saveUser(User user){
		user.setPassword(encoder.encode(user.getPassword()));
		System.out.println(user.getPassword());
		return repo.save(user);
	}
}
