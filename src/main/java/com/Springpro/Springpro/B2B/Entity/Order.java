package com.Springpro.Springpro.B2B.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

  
    @Setter
    @Column(name = "quantity")
    private int quantity;

    // الأساليب الخاصة بـ totalPrice
    @Setter
    @Getter
    @Column(name = "total_price")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProdOrd> prodOrds;


    public Order() {
    }

    public Order(Company company, int quantity, double totalPrice) {
        this.company = company;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public double getQuantity() {
        return quantity;
    }


    // Getters and setters
    // ...






}