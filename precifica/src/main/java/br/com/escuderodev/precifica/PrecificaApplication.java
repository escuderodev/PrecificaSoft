package br.com.escuderodev.precifica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class PrecificaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PrecificaApplication.class, args);
	}
}
