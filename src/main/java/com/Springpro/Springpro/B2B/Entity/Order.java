package com.Springpro.Springpro.B2B.Entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

  
    @Column(name = "quantity")
    private int quantity;

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

    // Getters and setters
    // ...


}