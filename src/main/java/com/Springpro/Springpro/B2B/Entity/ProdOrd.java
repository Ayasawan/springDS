package com.Springpro.Springpro.B2B.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "prod_ord")
public class ProdOrd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;


    public Object getId() {
        return id;
    }

}


