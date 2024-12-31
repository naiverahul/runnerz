package dev.rahulagar.runnerz;

import dev.rahulagar.runnerz.run.Location;
import dev.rahulagar.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

	private static  final Logger log  = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Something ange!");
	}
	@Bean
	CommandLineRunner  runner(){
		return args -> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
			log.info("Run:" + run);
		};
	}
}