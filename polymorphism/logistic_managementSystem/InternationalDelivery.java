package polymorphism.logistic_managementSystem;

public class InternationalDelivery extends Delivery{
    @Override
    double calculateCost(double distance) {
        return 550 + 20 *distance + 100;
    }
}
