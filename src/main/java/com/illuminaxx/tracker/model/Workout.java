/**
 * 
 */
package com.illuminaxx.tracker.model;

import java.util.Date;
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

/**
 * @author Illuminaxx
 *
 */
@Entity
@Table(name="workout")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int workoutId;
    
    @Column(nullable=false)
	private String workoutname;
    
	private Date date;
	
    @ManyToMany(mappedBy = "workouts")
    private Set<UserModel> users = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="workout_exercises",
	joinColumns = @JoinColumn(name="workout_id"),
	inverseJoinColumns = @JoinColumn(name="exercises_id"))
	private Set<Exercise> exercises = new HashSet<>();
	
	public Workout() {}


	public Workout(int workoutId, String workoutname, Date date) {
		this.workoutId = workoutId;
		this.workoutname = workoutname;
		this.date = new Date();
	}


	public int getWorkoutId() {
		return workoutId;
	}


	public void setWorkoutId(int workoutId) {
		this.workoutId = workoutId;
	}


	public String getWorkoutname() {
		return workoutname;
	}


	public void setWorkoutname(String workoutname) {
		this.workoutname = workoutname;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Set<Exercise> getExercises() {
		return exercises;
	}



	
	
	
	
	
}
