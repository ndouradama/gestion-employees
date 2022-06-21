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
public class Decaissement {

    private long amont;
    private Date payement_date;
    private Long created_by;
    private Long employees;
    private Trans_Type transType;
    private String description;
    private Mounth mounth;

}
