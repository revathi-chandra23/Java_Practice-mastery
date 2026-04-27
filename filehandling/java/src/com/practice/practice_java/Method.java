class Bank {
    int getInterest() {
        return 5;
    }
}

class SBI extends Bank {
    int getInterest() {
        return 7;
    }
}

public class Method {
    public static void main(String[] args) {
        Bank bank = new SBI();
        System.out.println(bank.getInterest());
    }
}