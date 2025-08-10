package com.project.studentmgt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.studentmgt.entities.Student;
import com.project.studentmgt.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository stdRepo;
	
	public Student addNewStd(Student std){
		return stdRepo.save(std);
	}
	
	public Student updateStudent(int id, Student updatedStd) {
		Student existingStd = stdRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));

		existingStd.setFull_name(updatedStd.getFull_name());
		existingStd.setDate_of_birth(updatedStd.getDate_of_birth());
		existingStd.setClass1(updatedStd.getClass1());
		existingStd.setContact_number(updatedStd.getContact_number());
		existingStd.setAddress(updatedStd.getAddress());

        return stdRepo.save(existingStd);
    }
	
	public void deleteStudent(int id) {
		stdRepo.deleteById(id);
	}

	
	public List<Student> getAllStudent()
	{
		return stdRepo.findAll();
	}
	
	public Student getStudentById(int id) {
        return stdRepo.findById(id)
               .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
    }

}

