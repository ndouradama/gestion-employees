package com.premier.GestionEmployee.dto;

import com.premier.GestionEmployee.model.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Salaire {
    private long amont;
    private Date payement_date;
    private Users created_by;
    private Employees employees;
    private Trans_Type transType;
    private Mounth mounth;
    private Statuts statuts;
}