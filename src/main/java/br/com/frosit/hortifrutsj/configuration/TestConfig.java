package br.com.frosit.hortifrutsj.configuration;

import br.com.frosit.hortifrutsj.domain.*;
import br.com.frosit.hortifrutsj.domain.enums.ClientType;
import br.com.frosit.hortifrutsj.domain.enums.StatusPayment;
import br.com.frosit.hortifrutsj.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
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
    private AdressRepository adressRespository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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

        cl1.getTelefones().addAll(Arrays.asList("98677645", "98443409"));

        clientRepository.save(cl1);

        Address e1 = new Address(null, "Rua Flores", "300", "Bl 1 apto 78", "Jardim", "09876638", cl1);
        Address e2 = new Address(null, "Av Matos", "105", "Sala 900", "Centro", "09876638", cl1);

        cl1.getEndereco().addAll(Arrays.asList(e1, e2));

        adressRespository.saveAll(Arrays.asList(e1, e2));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        Order ped1 = new Order(null, sdf.parse("25/04/2022 10:00"), cl1, e1);
        Order ped2 = new Order(null, sdf.parse("22/04/2022 12:00"), cl1, e2);

        Payment pgto1 = new CardPayment(null, StatusPayment.QUITADO, ped1, 6);
        ped1.setPayment(pgto1);

        cl1.getPedidos().addAll(Arrays.asList(ped1, ped2));

        orderRepository.saveAll(Arrays.asList(ped1, ped2));
        paymentRepository.save(pgto1);

        OrderItem ip1 = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
        OrderItem ip2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
        OrderItem ip3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);


        ped1.getItensDePedido().addAll(Arrays.asList(ip1, ip2));
        ped2.getItensDePedido().add(ip3);


        p1.getItensDePedido().add(ip1);
        p2.getItensDePedido().add(ip3);
        p3.getItensDePedido().add(ip1);



        orderItemRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

    }
}
