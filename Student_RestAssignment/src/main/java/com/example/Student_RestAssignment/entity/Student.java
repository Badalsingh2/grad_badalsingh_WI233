package com.example.Student_RestAssignment.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long regNo;

    private String name;

    private String school;

    private Integer standard;

    private String gender; // MALE / FEMALE

    private Double percentage;

    public Student() {
    }

    public Student(Long regNo, String name, String school, Integer standard, String gender, Double percentage) {
        this.regNo = regNo;
        this.name = name;
        this.school = school;
        this.standard = standard;
        this.gender = gender;
        this.percentage = percentage;
    }

    public Long getRegNo() {
        return regNo;
    }

    public void setRegNo(Long regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}



/*


GET		/students									- Get all the students

GET 	/students/regNo							- Specific student details of the given Registration number

POST	/students									- Insert a student record

PUT		/students/regNo							- Update specific student record

PATCH 	/students/regNo							- Update with given attributes

DELETE	/students/regNo							- Remove the student record for the given Registration number

GET		/students/school?name=KV					- List all students belonging to that school

GET		/students/school/count?name=DPS				- Total strength in that school

GET		/students/school/standard/count?class=5			- Total number of students in 5th standard

GET 	/students/result?pass=true/false				- List the students in descending order of their percentage (40% and above is pass)

GET		/students/strength?gender=MALE&standard=5	- How many Male students in standard 5


 */
