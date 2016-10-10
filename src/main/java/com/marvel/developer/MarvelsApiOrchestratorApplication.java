package com.marvel.developer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author diego.almeida
 *
 */
@SpringBootApplication
@EnableCaching
public class MarvelsApiOrchestratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelsApiOrchestratorApplication.class, args);
	}
}
