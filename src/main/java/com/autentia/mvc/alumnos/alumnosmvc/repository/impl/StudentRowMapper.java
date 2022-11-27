package com.autentia.mvc.alumnos.alumnosmvc.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;

public class StudentRowMapper implements RowMapper<Student>{
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
        return new Student(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4));
    }
}
