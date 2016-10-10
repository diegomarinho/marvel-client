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
public class MarvelsApp {

	public static void main(String[] args) {
		SpringApplication.run(MarvelsApp.class, args);
	}
}
