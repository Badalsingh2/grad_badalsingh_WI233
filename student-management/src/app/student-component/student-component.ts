import { Component } from '@angular/core';
import { StudentService } from '../services/student-service';
import { Students } from '../models/students';
import { Roleservice } from '../services/roleservice';

@Component({
  selector: 'app-student-component',
  standalone: false,
  templateUrl: './student-component.html',
  styleUrl: './student-component.css',
})
export class StudentComponent {
  students: Students[] = [
    new Students(1001, 1, "Rahul Sharma", 10, "Delhi Public School"),
    new Students(1002, 2, "Anita Verma", 9, "St. Mary's School"),
    new Students(1003, 3, "Rohan Patel", 8, "Green Valley School"),
    new Students(1004, 4, "Priya Singh", 10, "Modern High School"),
    new Students(1005, 5, "Aman Gupta", 7, "Sunrise Public School")
  ];

  role:string = "";
  showForm:boolean = false;
  editIndex:number = -1;
  student:Students = new Students(0,0,"",0,"");

  constructor( private rs:Roleservice){
    
    this.role = this.rs.getRole();
    console.log("Current role:", this.role);
  }

  openForm(){
    this.showForm = true;
    this.editIndex = -1;

    this.student = new Students(0,0,"",0,"");
  }

  saveStudent(){
    if(this.editIndex === -1){
      this.students.push({...this.student});
    }else{
      this.students[this.editIndex] = {...this.student};
      this.editIndex = -1;
    }
    this.student = new Students(0,0,"",0,"");
    this.showForm = false;
  }

  cancelForm(){

    this.showForm = false;

    this.student = {
      regNo: 0,
      rollNo: 0,
      name: "",
      standard: 0,
      school: ""
    };

    this.editIndex = -1;

  }
  // addStudent(event:any):void{
  //   event.preventDefault();

  //   let reg = event.target.elements[0].value;
  //   let roll = event.target.elements[1].value;
  //   let name = event.target.elements[2].value;
  //   let std = event.target.elements[3].value;
  //   let school = event.target.elements[4].value;

  //   let s = new Students(reg,roll,name,std,school);

  //   this.students.push(s);
  //   this.showForm = false;
  // }

  editStudent(i:number){
    this.showForm = true;
    this.editIndex = i;

    this.student = {...this.students[i]};
  }

  deleteStudent(index:number){
    this.students.splice(index,1);
  }
}
