package com.Springpro.Springpro.B2B.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "quests")
public class Quest {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Getter
//    @Setter
//    @Column(name = "quantity")
//    private int quantity;

//    @Getter
//    @Setter
//    @Column(name = "total_price")
//    private double totalPrice;


    @Setter
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;


    @ManyToOne
    @JoinColumn(name = "reproducer_id", referencedColumnName = "id")
    private Reproducer reproducer;



//    @OneToMany(mappedBy = "quest", cascade = CascadeType.ALL)
//    private List<ProdOrdd> prodOrds;







    // Getters and setters
    // ...
}