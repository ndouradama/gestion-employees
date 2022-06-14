package com.premier.GestionEmployee.model;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Person {
    @Column()
    private String firstname;

    @Column()
    private String lastname;

    @Column()
    private String addresse;

    @Column()
    @Pattern(regexp ="^(7[6-8]|70)([0-9]{3})([0-9]{2})([0-9]{2})")
    private String num;

    @Column()
    @Email
    @Pattern(regexp ="([A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,})")
    private String mail;
}
