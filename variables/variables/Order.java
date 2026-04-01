public class Order {

    static String platform = "Amazon"; // Static
    int orderId;                       // Instance
    double price;                      // Instance

    void placeOrder() {
        double discount = 100;         // Local
        final double DELIVERY_FEE = 50;

        double finalAmount = price - discount + DELIVERY_FEE;

        System.out.println("Order ID: " + orderId);
        System.out.println("Platform: " + platform);
        System.out.println("Final Amount: " + finalAmount);
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.orderId = 101;
        order.price = 2000;

        order.placeOrder();
    }
}