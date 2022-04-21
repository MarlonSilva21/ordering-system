package br.com.frosit.hortifrutsj.repositories;

import br.com.frosit.hortifrutsj.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {


}
