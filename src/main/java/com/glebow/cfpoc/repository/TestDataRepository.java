/**
 * 
 */
package com.glebow.cfpoc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.glebow.cfpoc.domain.TestData;

/**
 * @author pglebow
 *
 */
public interface TestDataRepository extends MongoRepository<TestData, Long> {

}
