package com.premier.GestionEmployee.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column()
    private long amont;

    @Column()
    private Date payement_date;


    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private Users created_by;

    @ManyToOne
    @JoinColumn(name = "employees_id")
    private Employees employees;


    @Column()
    private Trans_Type transType;

    @Column()
    private String description;

    @Column()
    private Mounth mounth;

    private Statuts statuts;

}
