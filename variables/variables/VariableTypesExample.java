class VariableTypesExample {

    int instanceVar = 20;          // Instance variable
    static int staticVar = 30;     // Static variable

    void show() {
        int localVar = 10;         // Local variable
        System.out.println(localVar);
        System.out.println(instanceVar);
        System.out.println(staticVar);
    }

    public static void main(String[] args) {
        VariableTypesExample obj = new VariableTypesExample();
        obj.show();
    }
}