package com.illuminaxx.tracker.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="weight")
public class Weight {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
	
    @Column(name = "date")
	private Date date;
	
    @Column(name = "Kilos")
	private Double kilos;
	
	@ManyToMany(mappedBy = "weights", cascade = {CascadeType.MERGE})
	private Set<UserModel> user = new HashSet<>();

	
	/*public Weight(int weightId, Date date, Double kilos) {
		this.weightId = weightId;
		this.date = date;
		this.kilos = kilos;
	}*/
	
	

	public Weight(int id, Date date, Double kilos, Set<UserModel> user) {
		this.id = id;
		this.date = date;
		this.kilos = kilos;
		this.user = user;
	}



	public Weight() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getKilos() {
		return kilos;
	}

	public void setKilos(Double kilos) {
		this.kilos = kilos;
	}

	public void setUser(Set<UserModel> user) {
		this.user = user;
	}



	/*public UserModel getUser() {
		return user;
	}*/

	
	
	
	
}
