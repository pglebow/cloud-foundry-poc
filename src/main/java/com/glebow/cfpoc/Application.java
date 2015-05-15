package com.glebow.cfpoc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.glebow.cfpoc.initializer.SampleWebApplicationInitializer;

/**
 * 
 */

/**
 * Test Application
 * @author pglebow
 *
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        application.initializers(new SampleWebApplicationInitializer());
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder(Application.class).initializers(new com.glebow.cfpoc.initializer.SampleWebApplicationInitializer()).run(args);
    }

}
