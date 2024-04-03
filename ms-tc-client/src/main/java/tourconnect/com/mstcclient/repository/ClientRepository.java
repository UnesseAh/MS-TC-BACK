package tourconnect.com.mstcclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tourconnect.com.mstcclient.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
