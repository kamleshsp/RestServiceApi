package com.test.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/studentDetails")
	public List<Student>  getStudentDetails() {

		return studentService.getAllStudents();
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudentDetailsById(@PathVariable("studentId") Integer studentId) {

		Optional<Student> student = studentService.getStudentDetails(studentId);

		return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/save")

	public String SaveDetails(@RequestBody Student student) {
		Student saveStudent = studentService.registerCourse(student);

		return "save successfully";

	}

}
