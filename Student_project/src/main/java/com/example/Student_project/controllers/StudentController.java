package com.example.Student_project.controllers;

import com.example.Student_project.modals.Student;
import com.example.Student_project.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public String form(){
        return "student";
    }

    @PostMapping("/insert")
    public String insertData(Student s){
        studentService.saveStudent(s);
        return "student";
    }

}
