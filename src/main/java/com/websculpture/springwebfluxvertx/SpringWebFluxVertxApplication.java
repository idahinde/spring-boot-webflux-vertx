package com.websculpture.springwebfluxvertx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebFluxVertxApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringWebFluxVertxApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.REACTIVE);
        springApplication.setAdditionalProfiles("prod");
        springApplication.run(args);
    }

}
