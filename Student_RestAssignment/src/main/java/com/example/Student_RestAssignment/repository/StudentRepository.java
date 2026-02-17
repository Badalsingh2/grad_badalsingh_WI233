package com.example.Student_RestAssignment.repository;

import com.example.Student_RestAssignment.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student, Long> {
    List<Student> findBySchool(String name);
    long countBySchool(String name);
    long countByStandard(int standard);
    List<Student> findByPercentageGreaterThanEqualOrderByPercentageDesc(double percentage);
    long countByGenderAndStandard(String gender, int standard);
}
