package com.project.studentConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentConsumerApplication.class, args);
		System.out.println("Student Consumer");
	}
}
