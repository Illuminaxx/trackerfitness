/**
 * 
 */
package com.illuminaxx.tracker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * @author Illuminaxx
 *
 */
@Entity
@Table(name="users")
public class UserModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
    
    @Column(name ="username")
	private String username;
	
	
	@Column(name = "firstname", nullable = false)
	@Size(max = 20)
	private String firstname;
	
	@Column(name = "lastname", nullable = false)
	@Size(max = 20)
	private String lastname;
	
	@Email
	@Size(min = 5, max = 254)
    @Column(length = 254, unique = true)
	private String email;
	
	@ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="users_workout", 
    joinColumns = @JoinColumn(name="users_id"),
    inverseJoinColumns = @JoinColumn(name="workout_id"))
	private Set<Workout> workouts = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "users_weight", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "weight_id", referencedColumnName = "id"))
	private Set<Weight> weights = new HashSet<>();
	
	
	
	public UserModel() {}

	public UserModel(String username, String firstname, String lastname, String email) {
		this.username = username;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Set<Workout> getWorkouts() {
		return workouts;
	}
	

    public Set<Weight> getWeights() {
		return weights;
	}

	public void setWeights(Set<Weight> weights) {
		this.weights = weights;
	}
	
	

	@Override
    public int hashCode() {
        return 31;
    }



	@Override
    public String toString() {
        return "User{" +
            ", firstName='" + firstname + '\'' +
            ", lastName='" + lastname + '\'' +
            ", email='" + email + '\'' +
            "}";
    }
    
    
	
	

}
