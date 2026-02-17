package com.example.Student_RestAssignment.controller;

import com.example.Student_RestAssignment.entity.Student;
import com.example.Student_RestAssignment.service.StudentService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAll();
    }

    @GetMapping("/{regNo}")
    public Student getByReg(@PathVariable long regNo){
        return studentService.getByReg(regNo).orElseThrow();
    }

    @PostMapping
    public Student insert(@RequestBody Student s){
        System.out.println(s);
        return studentService.save(s);
    }

    @PutMapping("/{regNo}")
    public ResponseEntity<Student> update(@PathVariable long regNo, @RequestBody Student student){
        Optional<Student> s = studentService.getByReg(regNo);
        if(s.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        student.setRegNo(regNo);
        Student updated = studentService.save(student);

        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/{regNo}")
    public ResponseEntity<Student> partialUpdate(@PathVariable long regNo,
                                                 @RequestBody Student student) {

        Student existing = studentService.getByReg(regNo)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (student.getName() != null)
            existing.setName(student.getName());

        if (student.getSchool() != null)
            existing.setSchool(student.getSchool());

        if (student.getGender() != null)
            existing.setGender(student.getGender());

        if (student.getStandard() != null)
            existing.setStandard(student.getStandard());

        if (student.getPercentage() != null)
            existing.setPercentage(student.getPercentage());

        Student saved = studentService.save(existing);

        return ResponseEntity.ok(saved);
    }


    @DeleteMapping("/{regNo}")
    public void delete(@PathVariable long regNo){
        studentService.delete(regNo);
    }

    @GetMapping("/school")
    public List<Student> getBySchool(@RequestParam String name){
        return studentService.getBySchool(name);
    }

    @GetMapping("/school/count")
    public long countBySchool(@RequestParam String name){
        return studentService.countBySchool(name);
    }

    @GetMapping("/school/standard/count")
    public long countByStandard(@RequestParam("class") int standard){
        return studentService.countByStandard(standard);
    }

    @GetMapping("/result")
    public List<Student> result(@RequestParam boolean pass){
        if(pass) return studentService.getPassedStudent();

        else return studentService.getAll().stream().filter(s->s.getPercentage()<40).toList();
    }

    @GetMapping("/strength")
    public long strength(@RequestParam String gender, @RequestParam int standard){
        return studentService.countByGenderAndStandard(gender, standard);
    }
}
