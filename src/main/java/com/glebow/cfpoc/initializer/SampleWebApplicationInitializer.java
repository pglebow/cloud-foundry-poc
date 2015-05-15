package com.glebow.cfpoc.initializer;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudException;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
public class SampleWebApplicationInitializer implements ApplicationContextInitializer<AnnotationConfigEmbeddedWebApplicationContext> {

    @Override
    public void initialize(AnnotationConfigEmbeddedWebApplicationContext applicationContext) {
        Cloud cloud = getCloud();
        ConfigurableEnvironment appEnvironment = applicationContext.getEnvironment();
        if (cloud != null) {
            appEnvironment.addActiveProfile("cloud");
            log.info("Cloud profile active");
        } else {
            log.info("Local profile active");
        }
        
    }

    private Cloud getCloud() {
        try {
            CloudFactory cloudFactory = new CloudFactory();
            return cloudFactory.getCloud();
        } catch (CloudException ce) {
            return null;
        }
    }
}