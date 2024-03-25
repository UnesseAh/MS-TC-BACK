package com.tourconnect.mctcagency;

import com.tourconnect.mctcagency.domain.Agency;
import com.tourconnect.mctcagency.repository.AgencyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class McTcAgencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(McTcAgencyApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AgencyRepository agencyRepository){
        return args -> {
            List<Agency> agencies = List.of(
                    Agency.builder()
                            .name("Agency 1")
                            .description("Description of Agency 1")
                            .city("City 1")
                            .address("Address 1")
                            .phoneNumber("123-456-7890")
                            .email("agency1@example.com")
                            .build(),
                    Agency.builder()
                            .name("Agency 2")
                            .description("Description of Agency 2")
                            .city("City 2")
                            .address("Address 2")
                            .phoneNumber("234-567-8901")
                            .email("agency2@example.com")
                            .build(),
                    Agency.builder()
                            .name("Agency 3")
                            .description("Description of Agency 3")
                            .city("City 3")
                            .address("Address 3")
                            .phoneNumber("345-678-9012")
                            .email("agency3@example.com")
                            .build(),
                    Agency.builder()
                            .name("Agency 4")
                            .description("Description of Agency 4")
                            .city("City 4")
                            .address("Address 4")
                            .phoneNumber("456-789-0123")
                            .email("agency4@example.com")
                            .build(),
                    Agency.builder()
                            .name("Agency 5")
                            .description("Description of Agency 5")
                            .city("City 5")
                            .address("Address 5")
                            .phoneNumber("567-890-1234")
                            .email("agency5@example.com")
                            .build()

            );

            agencyRepository.saveAll(agencies);
        };
    }

}
