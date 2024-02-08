package com.bfi.backend_banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendBanqueApplication {

	public static void main(String[] args) {

		SpringApplication.run(BackendBanqueApplication.class, args);
		System.out.println("It's working !"); //Display this message to ensure the back works

	}

}
