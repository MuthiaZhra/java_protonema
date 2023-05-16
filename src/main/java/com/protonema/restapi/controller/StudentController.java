package com.protonema.restapi.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.protonema.restapi.entity.Student;

import com.protonema.restapi.service.Impl.StudentServiceImpl;







@RestController
@RequestMapping("/api/student")
public class StudentController {


    @Autowired
   StudentServiceImpl studentService;



    //Post
    @PostMapping
    public ResponseEntity addStudent(@RequestBody Student student){

        studentService.addStudent(student);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    //Get
    @GetMapping
    public ResponseEntity getAllStudent(){
     List<Student> students = studentService.getAllStudent();

     return ResponseEntity.ok(students);
   
     
    }


    
    @GetMapping
    @RequestMapping("/detail")
    public ResponseEntity getStudentById(@RequestParam Long id){

        Optional<Student> student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

   //Put

   @PutMapping
    public ResponseEntity updateFullname(@RequestParam Long id, @RequestBody Student student){
        studentService.updateFullname(student.getFullname(), student.getAge(),student.getAddres(), id);

        return ResponseEntity.ok(HttpStatus.OK);
    }


    // @PutMapping 
    // public ResponseEntity updateAge(@RequestParam Long id, @RequestBody Student student){
    //     studentService.updateAge(student.getAge(), id);
    //     return ResponseEntity.ok(HttpStatus.OK);
    // }


    
    


    //Delete Method
    @DeleteMapping
    public ResponseEntity deleteStudentByid(@RequestParam Long id ){
        studentService.deleteStudentByid(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }
}
