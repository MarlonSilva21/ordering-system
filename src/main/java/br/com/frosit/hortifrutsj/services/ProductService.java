package br.com.frosit.hortifrutsj.services;

import br.com.frosit.hortifrutsj.domain.Product;
import br.com.frosit.hortifrutsj.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements CrudMethodsInterface<Product> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Product insert(Product obj) {
        return productRepository.save(obj);
    }

    @Override
    public Product update(Product obj, Long id) {
        Product entity = findById(id);
        updateDataProduct(entity, obj);
        return productRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
    }

    private static void updateDataProduct(Product entity, Product obj){
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
    }
}
