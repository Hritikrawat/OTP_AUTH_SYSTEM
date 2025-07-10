package com.otpsystem.otp_service.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.otpsystem.otp_service")
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Override
    protected String getDatabaseName() {
        return "OTP";
    }

    @Override
    protected  boolean autoIndexCreation(){
        return true;
    }
}
