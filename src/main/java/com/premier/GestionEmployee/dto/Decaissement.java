package com.premier.GestionEmployee.dto;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Mounth;
import com.premier.GestionEmployee.model.Trans_Type;
import com.premier.GestionEmployee.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Decaissement {

    private long amont;
    private Date payement_date;
    private Users created_by;
    private Employees employees;
    private Trans_Type transType;
    private String description;
    private Mounth mounth;

}
