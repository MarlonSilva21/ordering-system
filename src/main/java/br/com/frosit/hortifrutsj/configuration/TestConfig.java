package br.com.frosit.hortifrutsj.configuration;

import br.com.frosit.hortifrutsj.domain.Category;
import br.com.frosit.hortifrutsj.domain.Product;
import br.com.frosit.hortifrutsj.repositories.CategoryRepository;
import br.com.frosit.hortifrutsj.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Legumes");
        Category cat2 = new Category(null,"Frutas");

        Product p1 = new Product(null, "Tomate", 3.00);
        Product p2 = new Product(null, "Alface", 5.00 );
        Product p3 = new Product(null, "Banana", 7.00);

        cat1.getProducts().addAll(Arrays.asList(p1, p2, p3));
        cat2.getProducts().add(p2);

        p1.getCategories().add(cat1);
        p2.getCategories().addAll(Arrays.asList(cat1, cat2));
        p3.getCategories().add(cat1);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

    }
}
