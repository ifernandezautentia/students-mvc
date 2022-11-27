package com.autentia.mvc.alumnos.alumnosmvc.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.autentia.mvc.alumnos.alumnosmvc.controllers.dto.StudentDTO;
import com.autentia.mvc.alumnos.alumnosmvc.domain.Student;
import com.autentia.mvc.alumnos.alumnosmvc.services.StudentsService;

@Controller
public class StudentController{

    private final StudentsService studentsService;

    @Autowired
    public StudentController(StudentsService studentsService){
        this.studentsService = studentsService;
    }

    @GetMapping("/students")
    public String findStudents(Model model){
        final List<Student> students = studentsService.findStudents();
        final List<StudentDTO> studentDTOS = toStudentDTO(students);
        model.addAttribute("students", studentDTOS);
        return "students";
    }

    @PostMapping("/addstudent")
    public String newStudent(StudentDTO studentDTO, BindingResult result, Model model){
        final Student student = toStudent(studentDTO);
        studentsService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete-student/{nif}")
    public String deleteStudent(@PathVariable("nif") String nif){
        studentsService.deleteStudent(nif);
        return "redirect:/students";
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
