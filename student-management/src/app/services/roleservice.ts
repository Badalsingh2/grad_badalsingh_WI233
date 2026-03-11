import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Roleservice {
  role: string = "Guest";

  setRole(r:string){
    this.role = r;
  }
  getRole(){
    return this.role;
  }
}
