package com.tourconnect.mctcactivity;

import com.tourconnect.mctcactivity.domain.Activity;
import com.tourconnect.mctcactivity.repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
@EnableJpaAuditing
@SpringBootApplication
public class McTcActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(McTcActivityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ActivityRepository activityRepository) {
		return args -> {
			List<Activity> activities = List.of(
					Activity.builder()
							.name("Hiking")
							.about("Explore the scenic trails")
							.price(25.0)
							.duration("1 Day")
							.agencyId(1L)
							.build(),
					Activity.builder()
							.name("City Tour")
							.about("Discover the city's landmarks")
							.price(40.0)
							.duration("2 Days")
							.agencyId(1L)
							.build(),
					Activity.builder()
							.name("Cooking Class")
							.about("Learn to cook local dishes")
							.price(50.0)
							.duration("3 Days")
							.agencyId(1L)
							.build(),
					Activity.builder()
							.name("Scuba Diving")
							.about("Explore the underwater world")
							.price(100.0)
							.duration("4 Days")
							.agencyId(1L)
							.build(),
					Activity.builder()
							.name("Wine Tasting")
							.about("Sample local wines")
							.price(30.0)
							.duration("5 Days")
							.agencyId(1L)
							.build()
			);

			activityRepository.saveAll(activities);
		};
	}
}
