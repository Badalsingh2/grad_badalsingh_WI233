import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Badal", 21, "male", 20000, "programmer", "computer"));
        list.add(new Employee("Ankit", 24, "male", 30000, "programmer", "IT"));
        list.add(new Employee("Riya", 28, "female", 60000, "manager", "HR"));
        list.add(new Employee("Suresh", 35, "male", 25000, "clerk", "accounts"));
        list.add(new Employee("Neha", 26, "female", 32000, "programmer", "software"));
        list.add(new Employee("Aman", 40, "male", 80000, "manager", "operations"));
        list.add(new Employee("Pooja", 29, "female", 22000, "clerk", "admin"));
        list.add(new Employee("Rahul", 23, "male", 28000, "programmer", "IT"));
        list.add(new Employee("Sneha", 34, "female", 70000, "manager", "management"));
        list.add(new Employee("Vikram", 31, "male", 24000, "clerk", "finance"));
        list.add(new Employee("Kiran", 27, "male", 35000, "programmer", "computer"));


         System.out.println("Highest Paid Employee:     ");
         // Find the highest salary paid employee
         Optional<Employee> e = list.stream().max(Comparator.comparingInt(Employee::getSalary));
         System.out.println(e.toString());


         System.out.println("--------------------------------------------------");
         System.out.println("Total Number of Male and Female");
         // Find how many male & female employees working in company (numbers)
         Map<Object,Long> m5 = list.stream().collect(Collectors.groupingBy(e1->e1.gender, Collectors.counting()));
         System.out.println(m5);

         System.out.println("--------------------------------------------------");
         System.out.println("Total Expenses");
         // Total expense for the company department wise
         Map<Object,Integer> m6 = list.stream().collect(Collectors.groupingBy(e1->e1.department,Collectors.summingInt(e1->e1.salary)));
         System.out.println(m6);

        System.out.println("--------------------------------------------------");
        System.out.println("5 Seniors Employee:     ");
        // Who is the top 5 senior employees in the company
        list.stream().sorted((e1,e2) -> Integer.compare(e2.getAge(), e1.getAge())).limit(5).forEach(System.out::println);;


         System.out.println("--------------------------------------------------");
         System.out.println("Manager Employee: ");
         // Find only the names who all are managers
         list.stream().filter(e1 -> e1.designation.equalsIgnoreCase("manager")).map(e1->e1.toString()).forEach(System.out::println);

         list.stream().map(Employee::toString).forEach(System.out::println);
         System.out.println("--------------------------------------------------");
         System.out.println("Increase Salary");
         // Hike the salary by 20% for everyone except manager
         list.stream().filter(e -> !"manager".equalsIgnoreCase(e.designation)).map(Employee::increaseSalary).forEach(System.out::println);


        // list.forEach(System.out::println);
//        Employee size
        System.out.println(list.size())


    }
}

class Employee{
    String name;
    int age;
    String gender;
    int salary;
    String designation;
    String department;

    public Employee(String name,int age, String gender, int salary, String designation, String department) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
        this.designation = designation;
        this.department = department;
    }


    public String getHighestPaidEmployee(List<Employee> employees){
        return null;
    }

    public int getSalary(){
        return this.salary;
    }

    public int getAge(){
        return this.age;
    }

    public Employee increaseSalary(){
        this.salary += 0.2*salary;
        return this;
    }

    @Override
    public String toString() {
        String s = """
            \nName       : %s
            Age        : %d
            Gender     : %s
            Salary     : %d
            Designation: %s
            Department : %s
            """.formatted(name, age, gender, salary, designation, department);
        System.out.println(s);
        return "";
    }



}
