/**
 * 
 */
package com.illuminaxx.tracker.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Illuminaxx
 *
 */
@Entity
@Table(name ="content")
public class Workout_Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contentId;
    
	private int sets;
	private int reps;
	private float weight;
	
	@ManyToMany(mappedBy = "contents")
	private Set<Exercise> exercises = new HashSet<>();
	
	
	
	public Workout_Content() {}

	public Workout_Content(int contentId, int sets, int reps, float weight) {
		this.contentId = contentId;
		this.sets = sets;
		this.reps = reps;
		this.weight = weight;
	}



	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int sets) {
		this.sets = sets;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	
	
	
}
