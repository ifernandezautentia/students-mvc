package com.autentia.mvc.alumnos.alumnosmvc.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;
import com.autentia.mvc.alumnos.alumnosmvc.repository.impl.PostgresCrudRepository;

@Service
public class CrudStudentsService{

    private final PostgresCrudRepository studentRepository;

    @Autowired
    public CrudStudentsService(PostgresCrudRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> findStudents(){
        final List<Student> students = new ArrayList<>();
        final Iterator<Student> studentsIterator = studentRepository.findAll().iterator();
        while(studentsIterator.hasNext()){
            students.add(studentsIterator.next());
        }
        return students;
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(String nif){
        studentRepository.deleteById(nif);
    }
}
