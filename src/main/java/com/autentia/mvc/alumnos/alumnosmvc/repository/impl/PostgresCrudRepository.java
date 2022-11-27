package com.autentia.mvc.alumnos.alumnosmvc.repository.impl;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;

@Repository
public interface PostgresCrudRepository extends CrudRepository<Student, String>{
}
