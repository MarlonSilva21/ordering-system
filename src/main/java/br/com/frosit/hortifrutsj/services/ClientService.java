package br.com.frosit.hortifrutsj.services;

import br.com.frosit.hortifrutsj.domain.Client;
import br.com.frosit.hortifrutsj.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements CrudMethodsInterface<Client>{

    @Autowired
    ClientRepository clientRepository;


    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByName(String name) {
        return clientRepository.findByNomeContainingIgnoreCase(name);
    }

    @Override
    public Client insert(Client obj) {
        return clientRepository.save(obj);
    }

    @Override
    public Client update(Client obj, Long id) {
        Client entity = findById(id);
        updateDataCategory(entity, obj);
        return clientRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> user = clientRepository.findById(id);
        return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    private static void updateDataCategory(Client entity, Client obj){
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
    }
}
