package lld2.designPattern.behavioralDP.strategy.usingFactoryStrategy;

public class PayPalPayment implements PaymentStrategy {

    String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using PayPal - " + email);
    }

}
