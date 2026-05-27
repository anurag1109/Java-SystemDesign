package lld2.designPattern.behavioralDP.strategy.usingFactory;

public class PaymentContext {

    // this is factory method to get the strategy object based on the mode(here we
    // are creating object)
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
