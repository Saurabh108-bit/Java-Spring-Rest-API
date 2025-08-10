package com.project.studentConsumer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.project.studentConsumer.models.Student;

@Controller
public class StudentController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String homePage(Model model) {
		String url = "http://localhost:8080/student/api/allstudents";
		ResponseEntity<List<Student>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Student>>() {
				});

		List<Student> students = response.getBody();
		model.addAttribute("students", students);

		return "index.jsp";
	}

	@GetMapping("/insertStudent")
	public String insert() {
		return "insertStudent.jsp";
	}

	@PostMapping("/insertStd")
	public String submitStudent(@ModelAttribute Student student, Model model) {
		final String REST_API_URL = "http://localhost:8080/student/api/insert";
		try {
			Student saved = restTemplate.postForObject(REST_API_URL, student, Student.class);
			model.addAttribute("message", "Student inserted: " + saved.getFull_name());
		} catch (Exception e) {
			model.addAttribute("message", "Failed to insert Student: " + e.getMessage());
		}
		return "redirect:/";
	}
	
	@GetMapping("/editStd")
	public String editStudentForm(@RequestParam("student_id") int studentId, Model model) {
	    Student std = restTemplate.getForObject("http://localhost:8080/student/api/student/" + studentId, Student.class);
	    model.addAttribute("student", std);

	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    String dobFormatted = dateFormat.format(std.getDate_of_birth());
	    model.addAttribute("dobFormatted", dobFormatted);

	    return "updateStd.jsp";
	}


	@PostMapping("/update")
	public String updateStudent(@ModelAttribute Student student) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Student> entity = new HttpEntity<>(student, headers);

	    restTemplate.exchange(
	        "http://localhost:8080/student/api/update/" + student.getStudent_id(),
	        HttpMethod.PUT,
	        entity,
	        Void.class
	    );

	    return "redirect:/";
	}


	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
	    String deleteUrl = "http://localhost:8080/student/api/delete/" + id;
	    restTemplate.delete(deleteUrl);
	    return "redirect:/";
	}


}
