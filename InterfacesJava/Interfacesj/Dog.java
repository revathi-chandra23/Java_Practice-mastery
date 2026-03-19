interface Animal {
    void sound();
}
 // normal interface implementation without using lambda expression
public class Dog implements Animal {
    public void sound() {
        System.out.println("Bark");
    }
}