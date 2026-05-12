

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiEx {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "Yanksha", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "Francesca", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "Ramesh", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "Melanie", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "Padma", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "Milad", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "Uzma", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "Ali", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "Ram", 25, 160, "M", "IT", "Blore", 2010));

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getCity)));

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting())));

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.groupingBy(Employee:: getGender,Collectors.counting()))));

        System.out.println(empList.stream().map(Employee::getDeptName).distinct().toList());

        System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getAge)).map(Employee::getName).toList());

        System.out.println(empList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).get());

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining)))));

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Employee::getYearOfJoining)), Optional::get))));

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)))));

        System.out.println(empList.stream().filter(e->e.getCity().equalsIgnoreCase("blore")).sorted(Comparator.comparing(Employee::getName)).map(Employee::getName).toList());

        System.out.println(empList.stream().count());

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())));

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get());
        //25. To get a list of employees from each department whose salary is greater than the average salary of their department
   Map<String,Double> res=  empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.averagingLong(Employee::getSalary)));

        System.out.println(empList.stream().filter(e->e.getSalary()> res.get(e.getDeptName())).collect(Collectors.groupingBy(Employee::getDeptName)));

        System.out.println(empList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).toList());

        System.out.println(empList.stream().collect(Collectors.groupingBy(Employee::getDeptName,Collectors.collectingAndThen(Collectors.toList(),x->x.stream().
                sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(2).toList()))));



    }
}
