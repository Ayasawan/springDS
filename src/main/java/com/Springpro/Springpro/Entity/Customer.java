package com.Springpro.Springpro.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Customer_DB")
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;


    @Column(name = "lastName")
    private String lastName;

    @Column(name = "phone")
    private String phone;


    @Column(name = "location")
    private String location;
}






