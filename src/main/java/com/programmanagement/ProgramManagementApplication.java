package com.programmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * Main entry point for the application
 *
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
public class ProgramManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramManagementApplication.class, args);
	}

}
