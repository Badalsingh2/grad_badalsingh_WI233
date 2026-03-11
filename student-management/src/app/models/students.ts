export class Students {
    regNo:number;
    rollNo:number;
    name:string;
    standard:number;
    school:string;

    constructor(regNo:number,rollNo:number, name:string, standard:number, school:string){
        this.regNo = regNo;
        this.rollNo = rollNo;
        this.name = name;
        this.standard = standard;
        this.school = school;
    }
}

// regNo, rollNo, name, standard, school