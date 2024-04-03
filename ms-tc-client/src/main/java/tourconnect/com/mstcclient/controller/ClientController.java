package tourconnect.com.mstcclient.controller;

import org.springframework.web.bind.annotation.*;
import tourconnect.com.mstcclient.domain.Client;
import tourconnect.com.mstcclient.service.interfaces.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id){
        return clientService.findById(id).get();
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.create(client);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clientService.delete(id);
    }
}
