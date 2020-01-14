package com.illuminaxx.tracker.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.illuminaxx.tracker.model.Weight;
import com.illuminaxx.tracker.repository.WeightRepository;

/**
 * @author Illuminaxx
 *
 */
@Service
public class WeightService {
	
	@Autowired
	WeightRepository weightRepository;
	
	
	public List<Weight> getAllWeight() {
		List<Weight> allWeight = new ArrayList<>();
		weightRepository.findAll().forEach(weight -> allWeight.add(weight));
		return allWeight;
	}
	
	public Optional<Weight> findWeightById(int id_weight) {
		return weightRepository.findById(id_weight);
	}
	
	
	public void saveWeight(Weight weight) {
		weightRepository.save(weight);
	}

}
