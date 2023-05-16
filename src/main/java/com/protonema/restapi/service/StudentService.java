package com.protonema.restapi.service;

import java.util.List;
import java.util.Optional;

import com.protonema.restapi.entity.Student;


public interface StudentService{

    
    public void addStudent(Student student);

    public List<Student>getAllStudent();

    public Optional <Student> getStudentById(Long Id);


    public void updateFullname(String fullname, Integer age, String addres, Long id);
    

    public void deleteStudentByid(Long id );

   
}
