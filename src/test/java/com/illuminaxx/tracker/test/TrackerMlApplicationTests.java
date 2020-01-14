package com.illuminaxx.tracker.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.illuminaxx.tracker.TrackerMlApplication;
import com.illuminaxx.tracker.model.UserModel;
import com.illuminaxx.tracker.model.Weight;
import com.illuminaxx.tracker.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = TrackerMlApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TrackerMlApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	UserService userService;
	
	@LocalServerPort
	private int port;
	
	private String getUrlRoot() {
		return "http://localhost:" + port;
	}
	
	@Test
	public void contextLoads() {
		
	}
	
	/**
	 * Here we test that we can get all the users in the database
	 * using the GET method
	 */
	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		
		ResponseEntity<String> response = restTemplate.exchange(getUrlRoot()+ "/users",
				HttpMethod.GET, entity, String.class);
		
		Assert.assertNotNull(response.getBody());
 		
	}
	
	/**
	 * Here we test that we can fetch a single user using its id
	 */
	@Test
	public void testGetUserById() {
		UserModel user = restTemplate.getForObject(getUrlRoot() + "/users/1", UserModel.class);
		System.out.println(user.getFirstname());
		
		Assert.assertNotNull(user);
	}
	
	/**
	 * Here we test that we can create a user usong the POST method
	 */
	@Test
	public void testCreateUser() {
		UserModel user = new UserModel();
		
		user.setLastname("TEST");
		user.setFirstname("Test1");
		user.setEmail("test1@testmail.com");
		user.setUsername("T3ST");
		
		ResponseEntity<UserModel> postResponse = restTemplate.postForEntity(getUrlRoot() + "/add/user", user, UserModel.class);
		
		Assert.assertNotNull(postResponse.getBody().getId());
		Assert.assertNotNull(postResponse.getBody());
	}
	
	/**
	 * Here we test that we can update a user's information using PUT method
	 */
	@Test
	public void testUpdateUser() {
		int id = 1;
		UserModel user = restTemplate.getForObject(getUrlRoot() + "/users/" + id, UserModel.class);
		
		user.setLastname("Test");
		user.setFirstname("Tata");
		user.setUsername("TATA");
		
		restTemplate.put(getUrlRoot() + "/user/" + id, user);
		
		UserModel updatedUser = restTemplate.getForObject(getUrlRoot() + "/users/" +id, UserModel.class);
		
		Assert.assertNotNull(updatedUser);
	}
	
	/**
	 * Here we test that we can fetch a weight of user using GET Method 
	 */
	@Test
	public void testGetWeightByUserId() {
		int id = 1;
		UserModel user = restTemplate.getForObject(getUrlRoot() + "/users/" + id, UserModel.class);
		
		Object[] weightUser = user.getWeights().toArray();
		System.out.println(weightUser);
		Assert.assertNotNull(weightUser);
		
	}
	
	/**
	 * Here we test that we can add a weight for a specified user using POST method
	 */
	@Test
	public void testAddWeightByUser() {
		int id = 1;
		UserModel user = restTemplate.getForObject(getUrlRoot() + "/users/" + id, UserModel.class);
		
		Weight w = new Weight();
		
		w.setDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
		w.setKilos(112.4);
		
		user.getWeights().add(w);
		userService.updateUser(user);
		
		Assert.assertNotNull(user);
	}
	
	
}
