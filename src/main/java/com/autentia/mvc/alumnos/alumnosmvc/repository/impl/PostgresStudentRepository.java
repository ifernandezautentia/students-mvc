package com.autentia.mvc.alumnos.alumnosmvc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;
import com.autentia.mvc.alumnos.alumnosmvc.repository.StudentRepository;

@Repository
public class PostgresStudentRepository implements StudentRepository{

    public static final String FIND_ALL_STUDENTS = "SELECT nif, name, surname, phone FROM STUDENT";
    public static final String INSERT_STUDENT = "INSERT INTO STUDENT(nif, name, surname, phone) VALUES (?, ?, ?, ?)";
    public static final String DELETE_STUDENT_BY_NIF = "DELETE FROM STUDENT WHERE NIF = ? ";
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostgresStudentRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Student> findAll(){
        return jdbcTemplate.query(FIND_ALL_STUDENTS, new StudentRowMapper());
    }

    @Override
    public void save(Student student){
        jdbcTemplate.update(INSERT_STUDENT,
                student.getNif(),
                student.getName(),
                student.getSurname(),
                student.getPhone());
    }

    @Override
    public void deleteById(String nif){
        jdbcTemplate.update(DELETE_STUDENT_BY_NIF, nif);
    }

}
