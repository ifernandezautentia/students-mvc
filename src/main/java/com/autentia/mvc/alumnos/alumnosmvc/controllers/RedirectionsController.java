package com.autentia.mvc.alumnos.alumnosmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.autentia.mvc.alumnos.alumnosmvc.controllers.dto.StudentDTO;

@Controller
public class RedirectionsController{

    @GetMapping("/student/add")
    public String toAddStudent(Model model){
        model.addAttribute("student", emptyStudent());
        return "add-student";
    }

    private StudentDTO emptyStudent(){
        return new StudentDTO(null, null, null, null);
    }
}
