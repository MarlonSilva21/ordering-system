package br.com.frosit.hortifrutsj.repositories;

import br.com.frosit.hortifrutsj.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByNomeContainingIgnoreCase(String name);
}
