package lld2.designPattern.behavioralDP.strategy.usingFactoryStrategy;

public class Client {

    public static void main(String[] args) {
        // multiple strategies to make payment => strategy pattern
        PaymentContext mode1 = new PaymentFactory(Mode.CREDIT_CARD, "1463-7321-6875-8654");
        mode1.makePayment((10));
        ;

        PaymentContext mode2 = new PaymentFactory(Mode.PAYPAL, "example@gmail.com");
        mode2.makePayment(200);
    }
}
