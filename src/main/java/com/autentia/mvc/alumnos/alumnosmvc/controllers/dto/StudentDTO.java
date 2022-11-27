package com.autentia.mvc.alumnos.alumnosmvc.controllers.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StudentDTO{
    private final String nif;
    private final String name;
    private final String surname;
    private final String phone;
}
