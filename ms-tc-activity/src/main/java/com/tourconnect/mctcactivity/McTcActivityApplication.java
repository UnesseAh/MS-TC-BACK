package com.tourconnect.mctcactivity;

import com.tourconnect.mctcactivity.agencies.AgencyRestClient;
import com.tourconnect.mctcactivity.domain.Activity;
import com.tourconnect.mctcactivity.repository.ActivityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;
@EnableJpaAuditing
@EnableFeignClients
@SpringBootApplication
public class McTcActivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(McTcActivityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ActivityRepository activityRepository, AgencyRestClient agencyRestClient) {
		return args -> agencyRestClient.findAllAgencies().forEach(agency -> {
                    Activity activity1 = Activity.builder()
                            .name("Hiking")
                            .about("Explore the scenic trails")
                            .price(25.0)
                            .duration("1 Day")
                            .agencyId(agency.getId())
                            .build();
                    Activity activity2 = Activity.builder()
                            .name("City Tour")
                            .about("Discover the city's landmarks")
                            .price(40.0)
                            .duration("2 Days")
							.agencyId(agency.getId())
                            .build();
                    activityRepository.save(activity1);
                    activityRepository.save(activity2);
        });
	}
}
