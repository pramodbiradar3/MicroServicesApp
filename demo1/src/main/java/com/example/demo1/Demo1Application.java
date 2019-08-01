package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EntityScan("com.example")
public class Demo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}
		
	/*@Bean
	public PasswordEncoder getPasswordEncoder(){
		return new BCryptPasswordEncoder(6);
	}*/ 
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select().apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build()
          .enable(Boolean.parseBoolean(Boolean.TRUE.toString()));                                           
    }


}
