package com.project.studentmgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.studentmgt.entities.Student;
import com.project.studentmgt.services.StudentService;

@RestController
@RequestMapping("/student/api")
public class StudentController {
	
	@Autowired
	private StudentService stdServices;
	
	@PostMapping("/insert")
	public Student insertStd(@RequestBody Student std) {
		return stdServices.addNewStd(std);
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable int id) {
	    return stdServices.getStudentById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student std) {
	    return ResponseEntity.ok(stdServices.updateStudent(id, std));
	}


	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
          stdServices.deleteStudent(id);
          return ResponseEntity.ok("Student deleted successfully");
    }
	@GetMapping("/allstudents")
	public List<Student> getStudent()
	{
		return stdServices.getAllStudent();
	}

}

