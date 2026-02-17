package com.example.Student_RestAssignment.service;

import com.example.Student_RestAssignment.entity.Student;
import com.example.Student_RestAssignment.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Optional<Student> getByReg(long regNo){
        return studentRepository.findById(regNo);
    }

    public Student save(Student s){
        return studentRepository.save(s);
    }

    public void delete(long regNo){
        studentRepository.deleteById(regNo);
    }

    public List<Student> getBySchool(String school){
        return studentRepository.findBySchool(school);
    }

    public long countBySchool(String school){
        return studentRepository.countBySchool(school);
    }

    public long countByStandard(int standard){
        return studentRepository.countByStandard(standard);
    }

    public List<Student> getPassedStudent(){
        return studentRepository.findByPercentageGreaterThanEqualOrderByPercentageDesc(40);
    }

    public long countByGenderAndStandard(String gender, int standard){
        return  studentRepository.countByGenderAndStandard(gender,standard);
    }



}
