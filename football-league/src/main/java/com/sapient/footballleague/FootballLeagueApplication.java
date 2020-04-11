package com.sapient.footballleague;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.sapient")
@SpringBootApplication
public class FootballLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballLeagueApplication.class, args);
	}

}
