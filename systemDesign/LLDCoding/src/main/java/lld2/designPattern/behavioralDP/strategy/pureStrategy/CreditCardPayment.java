package lld2.designPattern.behavioralDP.strategy.pureStrategy;

public class CreditCardPayment implements PaymentStrategy {

    String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " using Credit Card - " + cardNumber);
    }
}
