package com.shiftmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class ShiftManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiftManagerApplication.class, args);
	}

}
