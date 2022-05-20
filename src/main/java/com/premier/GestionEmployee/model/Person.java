package com.premier.GestionEmployee.model;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Person {
    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String addresse;

    @Column
    private Integer num;

    @Column
    private String mail;

    public String test(){
        return "adama";
    }
}
