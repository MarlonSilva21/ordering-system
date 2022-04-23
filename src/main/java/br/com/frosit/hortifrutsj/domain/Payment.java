package br.com.frosit.hortifrutsj.domain;

import br.com.frosit.hortifrutsj.domain.enums.StatusPayment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_pagamentos")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class Payment implements Serializable {

    @Id
    private Long id;
    private Integer status;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "pedido_id")
    @MapsId
    private Order pedido;

    public Payment(Long id, StatusPayment status, Order pedido) {
        this.id = id;
        this.status = status.getCode();
        this.pedido = pedido;
    }
}
