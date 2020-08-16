package com.whiskeyworldwide.services;

import java.util.List;
import java.util.Optional;

import com.whiskeyworldwide.model.User;


public interface UserService {
	
	Optional<com.whiskeyworldwide.model.User> findById(Long id);
	
	List<User> findAll();
	
	Optional<User> findByEmail(String email);
	
	Optional<User> login(String email, String password);
	
	List<User> search(String keyword);
	
	List<User> lookUp(String fname, String lname);
	
	void save(User user);
	
	void deleteById(Long id);
	
	void update(User user);
	
	void giveRole(Long id, String role);

}
