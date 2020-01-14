/**
 * 
 */
package com.illuminaxx.tracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illuminaxx.tracker.model.UserModel;
import com.illuminaxx.tracker.repository.UserRepository;

/**
 * @author Illuminaxx
 *
 */
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	

	
	public List<UserModel> getAllUsers() {
		List<UserModel> allUsers = new ArrayList<UserModel>();
		userRepository.findAll().forEach(user -> allUsers.add(user));
		return allUsers;		
	}
	
	public UserModel getUserById(int id) {
		return userRepository.findById(id).get();
	}
	
	public void newUser(UserModel user) {
		userRepository.save(user);
	}
	
	public void updateUser(UserModel user) {
		userRepository.save(user);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
