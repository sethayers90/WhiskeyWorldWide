package com.whiskeyworldwide.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whiskeyworldwide.repos.UserRepository;
import com.whiskeyworldwide.model.User;


@Transactional
@Service
public class UsersServiceImpl implements UserService {

	
	private com.whiskeyworldwide.repos.UserRepository userRepository;
	
	@Autowired	
	public UsersServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Optional<User> login(String email, String password) {
		return userRepository.login(email, password);
	}

	@Override
	public List<User> search(String keyword) {
		return userRepository.search(keyword);
	}

	@Override
	public List<User> lookUp(String fname, String lname) {
		return userRepository.lookUp(fname, lname);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public void deleteById(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	public void update(User user) {
		userRepository.findById(user.getId()).ifPresent(u->{
			u.setFirstName(user.getFirstName());	
			u.setLastName(user.getLastName());
			u.setRole(user.getRole());
			
		});	
	
	}

	@Override
	public void giveRole(Long id, String role) {
		userRepository.findById(id).get().setRole(role);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
