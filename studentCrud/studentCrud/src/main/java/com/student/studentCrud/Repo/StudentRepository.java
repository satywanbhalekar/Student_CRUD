package com.student.studentCrud.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.studentCrud.Model.Student;



public interface StudentRepository extends JpaRepository<Student, Long>{

}

