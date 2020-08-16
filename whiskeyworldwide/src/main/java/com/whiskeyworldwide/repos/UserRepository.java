package com.whiskeyworldwide.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.whiskeyworldwide.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	
	  Optional<User> findByEmail(String email);
	  
	  @Query("FROM User WHERE email=?1 AND password=?2 ") Optional<User>
	  login(String email, String password);
	  
	  @Query("FROM User WHERE email=?1 OR lastName=?1 OR firstName=?1") List<User>
	  search(String keyword);
	  
	  @Query("FROM User WHERE firstName=?1 AND lastName =?2") List<User>
	  lookUp(String fname, String lname);
	 
}
