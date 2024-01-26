package com.student.studentCrud.Service;

import java.util.List;

import com.student.studentCrud.Model.Student;



public interface StudentService {

	
	 Student saveStudent(Student student);

	    List<Student> getAllStudent();

	    Student getStudentById(long id);

	    Student updateStudent(Student student, long id);

	    void deleteStudent(long id);
}
