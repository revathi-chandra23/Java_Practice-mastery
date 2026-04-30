class Employee {
    double salary;

    double calculateSalary() {
        return salary;
    }
}

class Manager extends Employee {
    double bonus = 5000;

    double calculateSalary() {
        return salary + bonus;
    }
}

class Developer extends Employee {
    double overtime = 2000;

    double calculateSalary() {
        return salary + overtime;
    }
}

public class EmployyeSalaryMain {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.salary = 30000;

        Developer d = new Developer();
        d.salary = 25000;

        System.out.println("Manager Salary: " + m.calculateSalary());
        System.out.println("Developer Salary: " + d.calculateSalary());
    }
}