package com.maf.availablehotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author izreqat
 *
 * APP Initializer
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.maf.availablehotel"})
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
    
    @Bean
    public RestTemplate restTemplate() {
    	return new RestTemplate();
    }
    
}