package com.student.studentCrud.Service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.studentCrud.Model.Student;
import com.student.studentCrud.Repo.StudentRepository;
import com.student.studentCrud.Service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentRepository studentRepository;
	

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optionalStudent= studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public Student updateStudent(Student student, long id) {
        if (studentRepository.existsById(id)) {
        	student.setId(id);
            return studentRepository.save(student);
        }
        return null; // Or handle the case where the employee with the given id doesn't exist.
    }

    @Override
    public void deleteStudent(long id) {
    	studentRepository.deleteById(id);
    }

	

}
