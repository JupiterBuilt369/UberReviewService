package com.example.UberReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class UberReviewServiceApplication {

	public static void main(String[] args) {

        SpringApplication.run(UberReviewServiceApplication.class, args);
        System.out.println("<------------JAI-SHREE-RAM-------->");
	}

}
