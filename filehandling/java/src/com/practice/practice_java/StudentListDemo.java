import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Student {
    private String name;
    private double cgpa;

    public Student(String name, double cgpa) {
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

public class StudentListDemo {

    public static void main(String[] args) {

      
        List<Integer> numbers = Arrays.asList(20, 30, 10, 50, 40);
        Collections.sort(numbers);
        System.out.println("Sorted Numbers: " + numbers);

        // Student list
        List<Student> students = new ArrayList<>();
        students.add(new Student("Revathi", 9.8));
        students.add(new Student("Someswari", 8.8));
        students.add(new Student("Shubham", 7.8));
        students.add(new Student("Rohit", 8.0));

     
        List<Student> sortedStudents =
                students.stream()
                        .sorted((x, y) -> Double.compare(x.getCgpa(), y.getCgpa()))
                        .toList();

        
        System.out.println("\nStudents sorted by CGPA:");
        sortedStudents.forEach(
                s -> System.out.println(s.getName() + " : " + s.getCgpa())
        );
    }
}