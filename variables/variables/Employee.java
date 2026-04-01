public class Employee {

    int employeeId;                // Instance variable
    String employeeName;           // Instance variable
    static String company = "Infosys";  // Static variable

    Employee(int id, String name) {
        employeeId = id;
        employeeName = name;
    }

    void display() {
        System.out.println(employeeId + " " + employeeName + " " + company);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Revathi");
        Employee e2 = new Employee(2, "Sowmya");

        e1.display();
        e2.display();
    }
}