/**
 * 
 */
package com.illuminaxx.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.illuminaxx.tracker.model.UserModel;
import com.illuminaxx.tracker.model.Weight;
import com.illuminaxx.tracker.service.UserService;

/**
 * @author Illuminaxx
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	UserService userService;

		
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	private List<UserModel> getAllUsers() {
		return userService.getAllUsers();
	}
	
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	private UserModel getUserById(@PathVariable("id") int id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(value = "/add/user", method = RequestMethod.POST)
	private int saveUser(@RequestBody UserModel user) {
		userService.newUser(user);
		return user.getId();
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	private ResponseEntity<?> modifyUser(@RequestBody UserModel user, @PathVariable("id") int id) {
		
		UserModel currentUser = userService.getUserById(id);
		
		if(currentUser == null) {
			return ResponseEntity.badRequest().body("Not updated !");
		}
		
		currentUser.setUsername(user.getUsername());
		currentUser.setLastname(user.getLastname());
		currentUser.setFirstname(user.getFirstname());
		userService.updateUser(currentUser);
		
		return new ResponseEntity<UserModel>(currentUser, HttpStatus.OK);

	}
	
	@RequestMapping(value="/user/{id}", method= RequestMethod.DELETE)
	private void deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}
	
	
	
	@RequestMapping(value = "/user/{user_id}/weight",  method = RequestMethod.GET)
	private Object[] getWeightByUserId(@PathVariable("user_id") int id) {
		
		UserModel currentUser = userService.getUserById(id);
		
		Object[] weightOfUser = currentUser.getWeights().toArray();
								/*.stream()
								.map(x -> x.getKilos())
								.collect(Collectors.toList());*/

		return weightOfUser;
		
	}
	
	@RequestMapping(value = "/user/{user_id}/weight/add", method = RequestMethod.POST)
	private int addWeightByUserId(@PathVariable("user_id") int id, @RequestBody Weight weight) {
		 
		UserModel currentUser = userService.getUserById(id);
		
		weight.setDate(weight.getDate());
		weight.setKilos(weight.getKilos());
		
		currentUser.getWeights().add(weight);
		userService.updateUser(currentUser);
		return weight.getId();
	}
	
}
