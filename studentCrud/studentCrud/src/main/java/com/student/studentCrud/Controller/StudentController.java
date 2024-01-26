package com.student.studentCrud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.studentCrud.Model.Student;
import com.student.studentCrud.Service.StudentService;



@RestController
public class StudentController {



    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
   
    public ResponseEntity<List<Student>> getAllEmployees() {
        List<Student> student = studentService.getAllStudent();
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
   
    

    @PostMapping("/create")
   
    public ResponseEntity<String> saveEmployee(@RequestBody Student student) {
    	Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>("data saved sucessfully "+savedStudent.getFirstname(), HttpStatus.CREATED);
    }
    

    
    
    
    @PutMapping("/student/{id}")
   
    public ResponseEntity<Student> updateStudent(@PathVariable long id, @RequestBody Student student) {
    	Student updatedStudent = studentService.updateStudent(student, id);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    
    
    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable long id) {
    	studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    
	
}
