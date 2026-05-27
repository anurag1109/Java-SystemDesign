package lld2.designPattern.behavioralDP.strategy.usingFactory;

public class Client {

    public static void main(String[] args) {
        // multiple strategies to make payment => strategy pattern
        PaymentStrategy mode1 = PaymentContext.context(Mode.CREDIT_CARD, "1463-7321-6875-8654");
        mode1.pay(100);

        PaymentStrategy mode2 = PaymentContext.context(Mode.PAYPAL, "example@gmail.com");
        mode2.pay(200);
    }
}
