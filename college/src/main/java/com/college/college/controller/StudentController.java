package com.college.college.controller;

import com.college.college.dto.CreateProfessorDTO;
import com.college.college.dto.CreateStudent;
import com.college.college.entity.Professor;
import com.college.college.entity.Student;
import com.college.college.service.ProfessorService;
import com.college.college.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    private final ProfessorService professorService;


    @GetMapping("/test")
    public String test(){
        return "this is test";
    }

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody CreateStudent createStudent){

        return studentService.addStudent(createStudent);
    }

    @PostMapping("/addProffesor")
    public Professor addProfessor(@RequestBody CreateProfessorDTO createProfessorDTO){
         return professorService.addProfesor(createProfessorDTO);
    }

}
