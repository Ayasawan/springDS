package com.Springpro.Springpro.B2B.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "Product_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Productt {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "companyy_id")
    private Company company;


    @OneToMany(mappedBy = "productt", cascade = CascadeType.ALL)
    private List<ProdOrdd> prodOrds;
}