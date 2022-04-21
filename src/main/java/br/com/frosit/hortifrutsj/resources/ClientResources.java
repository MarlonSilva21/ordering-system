package br.com.frosit.hortifrutsj.resources;

import br.com.frosit.hortifrutsj.domain.Client;
import br.com.frosit.hortifrutsj.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
@CrossOrigin("*")
public class ClientResources {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(clientService.findById(id));
    }

    @GetMapping("/desc/{name}")
    public ResponseEntity<Client> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(clientService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Client> insertClient(@RequestBody Client user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.insert(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client user) {
        return ResponseEntity.ok().body(clientService.update(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

}
