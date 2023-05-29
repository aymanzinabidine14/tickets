package com.booking.tickets;

import com.booking.tickets.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class TicketsApplication {


	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}


	@Bean
	CommandLineRunner commandLineRunner(AccountService accountService){
		return args -> {

			/*accountService.createUser("admin","123","admin@gmail.com","123");
			accountService.createUser("moderator","123","moderator@gmail.com","123");
			accountService.createUser("user","123","user@gmail.com","123");

			accountService.createRole("ADMIN");
			accountService.createRole("MODERATOR");
			accountService.createRole("USER");

			accountService.addRoletoUser("admin","ADMIN");
			accountService.addRoletoUser("moderator","MODERATOR");
			accountService.addRoletoUser("user","USER");*/

			accountService.createUser("admin2","12345","admin2@gmail.com","12345");
			accountService.addRoletoUser("admin2","ADMIN");


		};
	}

}
