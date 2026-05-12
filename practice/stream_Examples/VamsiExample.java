
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class VamsiExample {
    public static void main(String[] args) {
        List<Emp> employees= Arrays.asList(
                new Emp("Alice","HR",5000,500.0),
                new Emp("Bob","HR",5500,500.0),
                new Emp("Charlie","IT",7000,500.0),
                new Emp("David","IT",7200,500.0),
                new Emp("Eve","Finance",6000,500.0),
                new Emp("Frank","Finance",5800,500.0),
                new Emp("Grace","IT",7500,500.0),
                new Emp("Heidi","HR",5200,500.0)
        );

        Map<String, List<Emp>> dept=  employees.stream().collect(Collectors.groupingBy(Emp::getDept));
        System.out.println(dept);

        Map<String,Long> coun=employees.stream().collect(Collectors.groupingBy(Emp::getDept,Collectors.counting()));
        System.out.println(coun);

        // max salary
        Map<String, Optional<Emp>> maxsal=employees.stream().collect(Collectors.groupingBy(Emp::getDept,Collectors.maxBy(Comparator.comparing(Emp::getSalary))));
        System.out.println(maxsal);
    }
}




class Emp
{ 
    private String name,dept;
    private  int salary;
    private double bonus;

    public Emp(String name, String dept, int salary, double bonus) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        this.bonus = bonus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }



    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +

                '}';
    }
}