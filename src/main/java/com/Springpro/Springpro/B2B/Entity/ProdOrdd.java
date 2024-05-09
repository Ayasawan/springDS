package com.Springpro.Springpro.B2B.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "prod_ord")
public class ProdOrdd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "Reproducer_id", referencedColumnName = "id")
    private Reproducer reproducer;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "quest_id", referencedColumnName = "id")
    private Quest quest;


    public Object getId() {
        return id;
    }

}


