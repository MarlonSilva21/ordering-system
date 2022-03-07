package br.com.frosit.hortifrutsj.repositories;

import br.com.frosit.hortifrutsj.domain.Category;
import br.com.frosit.hortifrutsj.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByNameContainingIgnoreCase(String name);
}
