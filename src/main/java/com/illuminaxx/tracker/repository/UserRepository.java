/**
 * 
 */
package com.illuminaxx.tracker.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.illuminaxx.tracker.model.UserModel;

/**
 * @author Illuminaxx
 *
 */
@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {


}
