package br.com.frosit.hortifrutsj.resources;

import br.com.frosit.hortifrutsj.domain.Product;

import br.com.frosit.hortifrutsj.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/products")
@CrossOrigin("*")
public class ProductResources {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @GetMapping("/desc/{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name) {
        return ResponseEntity.ok().body(productService.findByName(name));
    }

    @PostMapping
    public ResponseEntity<Product> insertProduct(@RequestBody Product category) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.insert(category));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product category) {
        return ResponseEntity.ok().body(productService.update(category, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}

