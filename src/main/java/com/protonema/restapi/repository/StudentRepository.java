package com.protonema.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.protonema.restapi.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

    @Transactional
    @Modifying
    @Query(value = "UPDATE tb_student SET fullname=:fullname,age =:age,addres=:addres WHERE student_id=:id", nativeQuery = true)
    
    public void updateFullname(@Param("fullname") String fullname, @Param ("age")Integer age, @Param("addres") String addres,@Param ("id") Long id );
}



    // @Query(value = "UPDATE Tb_student SET age=:age WHERE student_id=:id", nativeQuery = true)
    // public void updateAge(@Param("age") Integer age, Long id);

