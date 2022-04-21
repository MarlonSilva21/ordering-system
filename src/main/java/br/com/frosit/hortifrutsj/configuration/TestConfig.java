package br.com.frosit.hortifrutsj.configuration;

import br.com.frosit.hortifrutsj.domain.Address;
import br.com.frosit.hortifrutsj.domain.Category;
import br.com.frosit.hortifrutsj.domain.Client;
import br.com.frosit.hortifrutsj.domain.Product;
import br.com.frosit.hortifrutsj.domain.enums.ClientType;
import br.com.frosit.hortifrutsj.repositories.AdressRespository;
import br.com.frosit.hortifrutsj.repositories.CategoryRepository;
import br.com.frosit.hortifrutsj.repositories.ClientRepository;
import br.com.frosit.hortifrutsj.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
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

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AdressRespository adressRespository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Legumes");
        Category cat2 = new Category(null, "Frutas");

        Product p1 = new Product(null, "Tomate", 3.00);
        Product p2 = new Product(null, "Alface", 5.00);
        Product p3 = new Product(null, "Banana", 7.00);

        cat1.getProducts().addAll(Arrays.asList(p1, p2));
        cat2.getProducts().add(p3);

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat2);

        categoryRepository.saveAll(Arrays.asList(cat1, cat2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3));

        Client cl1 = new Client(null, "Marlon", "marlon@gmail.com", "00999866723", ClientType.PESSOA_FISICA);

        cl1.getTelefone().addAll(Arrays.asList("98677645", "98443409"));

        clientRepository.save(cl1);

        Address e1 = new Address(null, "Rua Flores", "300", "Bl 1 apto 78", "Jardim", "09876638", cl1);
        Address e2 = new Address(null, "Av Matos", "105", "Sala 900", "Centro", "09876638", cl1);

        cl1.getEndereco().addAll(Arrays.asList(e1, e2));

        adressRespository.saveAll(Arrays.asList(e1, e2));

    }
}
