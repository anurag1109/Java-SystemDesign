package lld2.designPattern.behavioralDP.strategy.pureStrategy;

public class Client {

    public static void main(String[] args) {
        // multiple strategies to make payment => strategy pattern
        PaymentContext context = new PaymentContext(new CreditCardPayment("1234-5678-9876-5432"));
        context.makePayment(100);

        context = new PaymentContext(new PayPalPayment("example@gmail.com"));
        context.makePayment(200);
    }
}
