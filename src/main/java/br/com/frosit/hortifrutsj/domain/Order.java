package br.com.frosit.hortifrutsj.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_pedidos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instant;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Payment payment;

    @JsonIgnoreProperties("pedidos")
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Client cliente;



    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Address enderecoDeEntrega;

    @OneToMany(mappedBy="id.order")
    private final Set<OrderItem> itensDePedido = new HashSet<>();

    public Order(Long id, Date instant, Client cliente, Address enderecoDeEntrega) {
        this.id = id;
        this.instant = instant;
        this.cliente = cliente;
        this.enderecoDeEntrega = enderecoDeEntrega;
    }


}
