package lld2.designPattern.behavioralDP.strategy.usingFactoryStrategy;

public class PaymentContext {

    // this is the context class which will use the strategy object to make payment
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(int amount) {
        paymentStrategy.pay(amount);
    }
}
