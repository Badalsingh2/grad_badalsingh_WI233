package com.example.Student_project.services;

//import com.example.Student_project.config.PostgresConfig;
import com.example.Student_project.modals.Student;
import com.example.Student_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveStudent(Student s){
        studentRepository.save(s);

        jdbcTemplate.update(
                """
                INSERT INTO student (roll_no, name, standard, school)
                VALUES (?, ?, ?, ?)
                ON CONFLICT (roll_no)
                DO UPDATE SET
                    name = EXCLUDED.name,
                    standard = EXCLUDED.standard,
                    school = EXCLUDED.school
                """,
                s.getRollNo(),
                s.getName(),
                s.getStandard(),
                s.getSchool()
        );

    }
}
