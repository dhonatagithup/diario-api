package com.borges.diario_eletronico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication()
public class DiarioEletronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiarioEletronicoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123"));
	}
	
}
