package tourconnect.com.mstcclient.service.interfaces;

import org.springframework.stereotype.Service;
import tourconnect.com.mstcclient.domain.Client;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientService {
    List<Client> getAll();
    Client create(Client client);
    Optional<Client> findById(Long id);
    void delete(Long id);
}
