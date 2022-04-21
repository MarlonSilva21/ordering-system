package br.com.frosit.hortifrutsj.domain;

import br.com.frosit.hortifrutsj.domain.enums.StatusPayment;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@NoArgsConstructor
public class CardPayment extends Payment implements Serializable {

    private Integer numeroDeParcelas;

    public CardPayment(Long id, StatusPayment status, Order pedido, Integer numeroDeParcelas) {
        super(id, status, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
