package com.autentia.mvc.alumnos.alumnosmvc.services;

import com.autentia.mvc.alumnos.alumnosmvc.controllers.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

@Service
public class StudentDTOValidatorService {

    public ObjectError validate(StudentDTO studentDTO) {
        final boolean isNIFBlank = studentDTO.getNif().isBlank();
        final boolean isNameBlank = studentDTO.getName().isBlank();
        final boolean isSurnameBlank = studentDTO.getSurname().isBlank();
        final boolean isPhoneBlank = studentDTO.getPhone().isBlank();
        if(isNIFBlank || isNameBlank || isSurnameBlank || isPhoneBlank){
            return new ObjectError("globalError", "Todos los campos deben de rellenarse");
        }
        return null;
    }

}
