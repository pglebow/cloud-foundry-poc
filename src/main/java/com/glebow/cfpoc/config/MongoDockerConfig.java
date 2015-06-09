/**
 * 
 */
package com.glebow.cfpoc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * @author pglebow
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.glebow.cfpoc")
@Profile("docker")
public class MongoDockerConfig extends AbstractMongoConfiguration {

    @Value("#{environment.MONGO_1_PORT_27017_TCP_ADDR}")
    private String mongoHost;
    
    @Value("#{environment.MONGO_1_PORT_27017_TCP_PORT}")
    private int mongoPort;

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient(mongoHost, mongoPort);
    }

    @Override
    protected String getDatabaseName() {
        return "pocDb";
    }
}
