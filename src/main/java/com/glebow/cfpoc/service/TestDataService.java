/**
 * 
 */
package com.glebow.cfpoc.service;

import java.util.Set;

import com.glebow.cfpoc.domain.TestData;

/**
 * Test data service
 * @author pglebow
 *
 */
public interface TestDataService {

    /**
     * Returns a response for the name
     * @param name
     * @return TestData
     */
    TestData getResponse(String name);
    
    /**
     * Returns all persisted entities, if any
     * @return null or a list
     */
    Set<TestData> getAll();
    
    /**
     * Emails the test data to the recipient
     * @param data
     * @param address
     */
    void email(Set<TestData> data, String recipient);
}
