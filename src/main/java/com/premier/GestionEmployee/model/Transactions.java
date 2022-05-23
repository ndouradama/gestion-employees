package com.premier.GestionEmployee.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private long amont;

    @Column ()
    private int payement_date;

    @Column()
    private String created_by;

    @Column()
    private String personnel;

    @Column()
    private String description;

    @Column()
    private Trans_Type transType;

}
