package com.protonema.restapi.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.protonema.restapi.entity.Student;
import com.protonema.restapi.repository.StudentRepository;
import com.protonema.restapi.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
         studentRepository.save(student);
    }


    @Override
    public List<Student> getAllStudent(){
       
        return studentRepository.findAll();



    }



  



    @Override
    public Optional <Student> getStudentById(Long Id) {
      Optional<Student> student = studentRepository.findById(Id);

      return student;

    }


   
    @Override
    public void updateFullname(String fullname, Integer age, String addres, Long id){
        studentRepository.updateFullname(fullname, age, addres, id);
    }

    
   


    @Override
    public void deleteStudentByid(Long id) {
        studentRepository.deleteById(id);
    }


   


    


  

   


    
}
