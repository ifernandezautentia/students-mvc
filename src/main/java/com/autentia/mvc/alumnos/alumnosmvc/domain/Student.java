package com.autentia.mvc.alumnos.alumnosmvc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class Student implements Persistable<String>{

    @Id
    private final String nif;
    private final String name;
    private final String surname;
    private final String phone;
    @Transient
    private boolean newEntity;

    public Student(String nif, String name, String surname, String phone){
        this.nif = nif;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.newEntity = Boolean.TRUE;
    }

    @Override
    public String getId(){
        return nif;
    }

    @Override
    public boolean isNew(){
        return newEntity;
    }
}
