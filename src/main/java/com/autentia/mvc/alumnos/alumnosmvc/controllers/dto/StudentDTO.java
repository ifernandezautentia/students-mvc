package com.autentia.mvc.alumnos.alumnosmvc.controllers.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode
public class StudentDTO{
    @NotBlank(message = "{student.nif.not.empty}")
    private final String nif;
    @NotBlank(message = "{student.name.not.empty}")
    private final String name;
    @NotBlank(message = "{student.surname.not.empty}")
    private final String surname;
    @NotBlank(message = "{student.phone.not.empty}")
    private final String phone;
}
