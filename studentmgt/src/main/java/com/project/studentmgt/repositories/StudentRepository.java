package com.project.studentmgt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.studentmgt.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
