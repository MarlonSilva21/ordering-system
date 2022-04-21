package br.com.frosit.hortifrutsj.domain;

import br.com.frosit.hortifrutsj.domain.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "tb_clientes")
@NoArgsConstructor
@Data
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipoCliente;

    public Client(Long id, String nome, String email, String cpfOuCnpj, ClientType tipoCliente) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipoCliente = tipoCliente.getCode();
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "cliente")
    private final List<Address> endereco = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_telefones")
    private final Set<String> telefones = new HashSet<>();

}
