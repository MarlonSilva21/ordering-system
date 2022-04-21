package br.com.frosit.hortifrutsj.repositories;

import br.com.frosit.hortifrutsj.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
