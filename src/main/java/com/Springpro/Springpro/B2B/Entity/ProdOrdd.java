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
    @JoinColumn(name = "productt_id", referencedColumnName = "id")
    private Productt productt;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "orderr_id", referencedColumnName = "id")
    private Orderr orderr;


    public Object getId() {
        return id;
    }

}


