package lld2.designPattern.behavioralDP.strategy.usingFactoryStrategy;

public class PaymentContext {

    public static PaymentStrategy context(Mode mode, String details) {
        switch (mode) {
            case CREDIT_CARD:
                return new CreditCardPayment(details);
            case PAYPAL:
                return new PayPalPayment(details);
            default:
                throw new IllegalArgumentException("Unsupported payment mode: " + mode);
        }
    }
}
