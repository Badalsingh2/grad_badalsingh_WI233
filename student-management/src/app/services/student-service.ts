import { Injectable } from '@angular/core';
import { Students } from '../models/students';

@Injectable({
  providedIn: 'root',
})
export class StudentService {
  students: Students[] = [
    new Students(1001, 1, "Rahul Sharma", 10, "Delhi Public School"),
    new Students(1002, 2, "Anita Verma", 9, "St. Mary's School"),
    new Students(1003, 3, "Rohan Patel", 8, "Green Valley School"),
    new Students(1004, 4, "Priya Singh", 10, "Modern High School"),
    new Students(1005, 5, "Aman Gupta", 7, "Sunrise Public School")
  ];
  addStudent(s:Students){
    this.students.push(s);
  }

  getStudents():Students[]{
    return this.students;
  }
}
