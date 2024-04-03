package tourconnect.com.mstcclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import tourconnect.com.mstcclient.domain.Client;
import tourconnect.com.mstcclient.repository.ClientRepository;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class MsTcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTcClientApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ClientRepository clientRepository){
		return args -> {
			List<Client> clients = List.of(
					Client.builder()
							.username("user-1")
							.password("password-1")
							.build(),
					Client.builder()
							.username("user-2")
							.password("password-2")
							.build(),
					Client.builder()
							.username("user-3")
							.password("password-3")
							.build(),
					Client.builder()
							.username("user-4")
							.password("password-4")
							.build(),
					Client.builder()
							.username("user-5")
							.password("password-5")
							.build()
			);

			clientRepository.saveAll(clients);
		};
	}

}
