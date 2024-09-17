package com.restapi_practice;

import com.restapi_practice.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({JpaConfig.class})
public class RestapiPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiPracticeApplication.class, args);
	}

}
