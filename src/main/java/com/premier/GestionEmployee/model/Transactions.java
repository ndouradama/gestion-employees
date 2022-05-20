package com.premier.GestionEmployee.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private long amont;

    @Column ()
    private Date payement_date;

    @Column()
    private String created_by;

    @Column()
    private String personnel;


    @Column()
    private String description;

    private TransType transType;


}
