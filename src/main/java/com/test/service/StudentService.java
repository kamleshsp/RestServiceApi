package com.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.entity.Course;
import com.test.entity.Student;
import com.test.repository.CourseRepository;
import com.test.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Student> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	
	public Optional<Student> getStudentDetails(Integer studentId)
	{
		return studentRepository.findById(studentId);
	}
	
	
	public Student registerCourse(Student student)
	{
		
		
	Student savedStudent =	 studentRepository.save(student);
        
        return savedStudent;
				
	}

}
