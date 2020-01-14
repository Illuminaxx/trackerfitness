/**
 * 
 */
package com.illuminaxx.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.illuminaxx.tracker.model.Weight;
import com.illuminaxx.tracker.service.WeightService;

/**
 * @author Illuminaxx
 *
 */
@RestController
public class WeightController {

	@Autowired
	WeightService weightService;
	
	
	@RequestMapping(value = "/weights", method = RequestMethod.GET)
	private List<Weight> getAllWeight() {
		return weightService.getAllWeight();
	}
	
	
	@RequestMapping(value = "/add/weight",  method = RequestMethod.POST)
	private int saveWeight(@RequestBody Weight weight) {
		weightService.saveWeight(weight);
		return weight.getId();
	}
	
	
}
