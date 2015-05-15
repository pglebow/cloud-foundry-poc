/**
 * 
 */
package com.glebow.cfpoc.test.domain;

import lombok.extern.slf4j.Slf4j;

import org.junit.Test;

import com.glebow.cfpoc.domain.TestData;

/**
 * @author pglebow
 *
 */
@Slf4j
public class TestDataTest {

    /**
     * Test method for {@link com.glebow.cfpoc.domain.TestData#toString()}.
     */
    @Test
    public void testToString() {
        TestData t = new TestData(1l, "Hello");
        log.info(t.toString());
    }

}
