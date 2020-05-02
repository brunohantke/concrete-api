package com.concrete.hantke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
@ImportResource(value="classpath:hsql_cfg.xml")
public class ConcreteApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcreteApiApplication.class, args);
	}

}
