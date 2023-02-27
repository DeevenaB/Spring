package com.example.spring.mongo.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class configuration {
	
    @Bean
    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	}
    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder().title("BooksStore Api")
    			.description("Details about Books")
    			.termsOfServiceUrl("Terms of service")
    			.licenseUrl("Licensed URL")
    			.version("3.0")
    			.build();
    }
}

