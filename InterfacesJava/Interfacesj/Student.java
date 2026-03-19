interface Serializable {
}
// marker interface, no methods to implement
public class Student implements Serializable {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    static void display(Student s) {
        System.out.println("ID: " + s.id + ", Name: " + s.name);
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Revathi");
        Student s2 = new Student(2, "Tannidi");
        display(s1);
        display(s2);
    }
}