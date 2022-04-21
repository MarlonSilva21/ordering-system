package br.com.frosit.hortifrutsj.repositories;

import br.com.frosit.hortifrutsj.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address, Long> {

    Address findByNumeroContainingIgnoreCase(String numero);
}
