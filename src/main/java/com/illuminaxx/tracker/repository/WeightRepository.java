/**
 * 
 */
package com.illuminaxx.tracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.illuminaxx.tracker.model.Weight;

/**
 * @author Illuminaxx
 *
 */
@Repository
public interface WeightRepository extends CrudRepository<Weight, Integer> {

	@Override
	Optional<Weight> findById(Integer id);
	
	

}
