package com.fbn.hashmap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.fbn.hashmap.repository")
public class Application {
	
	 @Bean	
	 @Autowired
	  public Cloud cloud() {
		 CloudFactory cfr=new CloudFactory();
		 Cloud cf=cfr.getCloud();
	    return cf;
	  }

     public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
