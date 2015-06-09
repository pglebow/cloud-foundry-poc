/**
 * 
 */
package com.glebow.cfpoc.web;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.glebow.cfpoc.domain.TestData;
import com.glebow.cfpoc.service.TestDataService;
import com.google.common.collect.Lists;

/**
 * @author pglebow
 *
 */
@RestController
@RequestMapping("/data")
public class TestDataController {
    
    @Autowired
    private TestDataService service;    
    
    @RequestMapping("/test")
    public TestData hello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return service.getResponse(name);
    }
    
    @RequestMapping("/findAll")
    public List<TestData> getAll() {
        List<TestData> retVal = Lists.newArrayList();
        Iterable<TestData> iterable = service.getAll();
        if ( iterable != null ) {
            Iterator<TestData> iterator = iterable.iterator();
            while (iterator.hasNext()) {
                retVal.add(iterator.next());
            }
        }
        return retVal;
    }
    
    @RequestMapping("/mail")
    public void mail(@RequestParam(value="to", required=true) String to) {
        service.email(service.getAll(), to);
    }

}
