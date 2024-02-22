package com.agria.studentRepo;

import com.agria.studentRepo.models.Player;
import com.agria.studentRepo.respository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class StudentRepoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentRepoApplication.class, args);
	}

	@Autowired
	private PlayerRepo playerRepo;
	@Override
	public void run(String... args) throws Exception {

	}
}
