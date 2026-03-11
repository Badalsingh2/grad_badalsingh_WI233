import { Component } from '@angular/core';
import { User } from '../models/user';
import { Router } from '@angular/router';
import { Roleservice } from '../services/roleservice';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {

  user:User = {
    username: "",
    password: "",
    role: ""

  };
  constructor(private router:Router, private rs:Roleservice){}

  abc(event1:any){
    event1.preventDefault();

    this.user.username = event1.target.elements[0].value;
    this.user.password = event1.target.elements[1].value;
    this.user.role = event1.target.elements[2].value;

    console.log(this.user);
    if(this.user.username == this.user.password){
      this.rs.setRole(this.user.role)
      this.router.navigate(["students"])
    }
  }

}