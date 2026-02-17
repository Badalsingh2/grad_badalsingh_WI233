package com.example.Student_project.repository;

import com.example.Student_project.modals.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
