package com.necessafy.rebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class WebRecommendationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebRecommendationApplication.class, args);
	}

}
