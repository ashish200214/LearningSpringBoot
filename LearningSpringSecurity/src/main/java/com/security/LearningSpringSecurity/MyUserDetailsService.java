package com.security.LearningSpringSecurity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.LearningSpringSecurity.model.UserModel;
import com.security.LearningSpringSecurity.repo.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserModel> user=repository.findByUsername(username);
		if (user.isPresent()) {
			UserModel userObject = user.get();
			
			return  User.builder()
					.username(userObject.getUsername())
					.password(userObject.getPassword())
					.roles(userObject.getRole())
					.build();
		}
		else {
			throw new UsernameNotFoundException(username);
		}
		
	}
	
}
