public class LocalVariableExample {

    void display() {
        int number = 10;   // Local variable
        System.out.println("Local variable value: " + number);
    }

    public static void main(String[] args) {
        LocalVariableExample obj = new LocalVariableExample();
        obj.display();
    }
}
