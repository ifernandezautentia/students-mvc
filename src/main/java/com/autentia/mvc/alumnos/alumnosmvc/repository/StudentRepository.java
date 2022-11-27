package com.autentia.mvc.alumnos.alumnosmvc.repository;

import java.util.List;

import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;

public interface StudentRepository{
    List<Student> findAll();

    void save(Student student);

    void deleteById(String nif);
}
