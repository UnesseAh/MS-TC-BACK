package tourconnect.com.mstcclient.service.implementations;

import org.springframework.stereotype.Service;
import tourconnect.com.mstcclient.domain.Client;
import tourconnect.com.mstcclient.repository.ClientRepository;
import tourconnect.com.mstcclient.service.interfaces.ClientService;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isEmpty()){
            throw new IllegalArgumentException("Client with id " + id + " doesn't exist");
        }
        clientRepository.delete(client.get());
    }
}
