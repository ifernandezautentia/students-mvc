package com.autentia.mvc.alumnos.alumnosmvc.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.mvc.alumnos.alumnosmvc.controllers.dto.StudentDTO;
import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;
import com.autentia.mvc.alumnos.alumnosmvc.services.CrudStudentsService;

@RestController
@RequestMapping("/rest/student")
public class RestStudentController{

    private final CrudStudentsService studentsService;

    @Autowired
    public RestStudentController(CrudStudentsService studentsService){
        this.studentsService = studentsService;
    }

    @GetMapping()
    public List<StudentDTO> findStudents(){
        final List<Student> students = studentsService.findStudents();
        return toStudentDTO(students);
    }

    @PostMapping()
    public void newStudent(@RequestBody StudentDTO studentDTO){
        final Student student = toStudent(studentDTO);
        studentsService.addStudent(student);
    }

    @DeleteMapping("/{nif}")
    public void deleteStudent(@PathVariable("nif") String nif){
        studentsService.deleteStudent(nif);
    }

    private Student toStudent(StudentDTO studentDTO){
        return new Student(
                studentDTO.getNif(),
                studentDTO.getName(),
                studentDTO.getSurname(),
                studentDTO.getPhone());
    }

    private static List<StudentDTO> toStudentDTO(List<Student> students){
        return students.stream()
                .map(student -> new StudentDTO(
                        student.getNif(),
                        student.getName(),
                        student.getSurname(),
                        student.getPhone()))
                .collect(Collectors.toList());
    }
}
