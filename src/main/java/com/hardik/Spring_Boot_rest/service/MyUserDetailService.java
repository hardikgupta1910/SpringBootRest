package com.hardik.Spring_Boot_rest.service;


import com.hardik.Spring_Boot_rest.model.User;
import com.hardik.Spring_Boot_rest.model.UserPrinciple;
import com.hardik.Spring_Boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.findByUsername(username);
		if(user==null){
			System.out.println("user 404");
			throw new UsernameNotFoundException("user 404 not found");
		}
		return new UserPrinciple(user);
	}
}
