package br.com.frosit.hortifrutsj.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_products")
@NoArgsConstructor
@Data
public class Product implements Serializable {

    @JsonIgnoreProperties("products")
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private final List<Category> categories = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;

    @JsonIgnore
    @OneToMany(mappedBy = "id.product")
    private final Set<OrderItem> itensDePedido = new HashSet<>();

    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @JsonIgnoreProperties
    public List<Order> getPedidos() {
        List<Order> listaDePedidos = new ArrayList<>();
        itensDePedido.forEach((OrderItem x) -> listaDePedidos.add(x.getOrder()));
        return listaDePedidos;
    }
}
