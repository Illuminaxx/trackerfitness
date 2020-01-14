/**
 * 
 */
package com.illuminaxx.tracker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="exercises")
public class Exercise {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int exerciseId;
	private String exerciseName;
	private String muscleGroup;

	
	@ManyToMany(mappedBy = "exercises")
	private Set<Workout> workouts = new HashSet<>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name="content_exercises",
	joinColumns = @JoinColumn(name="exercises_id"),
	inverseJoinColumns = @JoinColumn(name="content_id"))
	private Set<Workout_Content> contents = new HashSet<>();

	public int getExerciseId() {
		return exerciseId;
	}

	public void setExerciseId(int exerciseId) {
		this.exerciseId = exerciseId;
	}

	public String getExerciseName() {
		return exerciseName;
	}

	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}

	public String getMuscleGroup() {
		return muscleGroup;
	}

	public void setMuscleGroup(String muscleGroup) {
		this.muscleGroup = muscleGroup;
	}

	public Set<Workout_Content> getContents() {
		return contents;
	}
	

}
