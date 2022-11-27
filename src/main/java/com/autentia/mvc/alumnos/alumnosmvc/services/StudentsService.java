package com.autentia.mvc.alumnos.alumnosmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;
import com.autentia.mvc.alumnos.alumnosmvc.repository.StudentRepository;

@Service
public class StudentsService{

    private final StudentRepository studentRepository;

    @Autowired
    public StudentsService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> findStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(String nif){
        studentRepository.deleteById(nif);
    }
}
