/**
 * 
 */
package com.glebow.cfpoc.domain;

import java.io.Serializable;

import lombok.Data;

import org.springframework.data.annotation.Id;

/**
 * Test endpoint representation
 * @author pglebow
 *
 */
@Data
public class TestData implements Serializable {

    /**
     * Serialization
     */
    private static final long serialVersionUID = -7177160483022417616L;
    
    @Id
    private final long id;
    
    private final String content;

}
