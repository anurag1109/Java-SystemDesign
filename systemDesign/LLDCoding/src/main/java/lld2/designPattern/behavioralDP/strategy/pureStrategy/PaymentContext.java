package lld2.designPattern.behavioralDP.strategy.pureStrategy;

// here we are directly passing the strategy object to the context class and using it to make payment
// we are not using any factory method to create the strategy object we are directly creating it in the client class and
// passing it to the context class
public class PaymentContext {
    PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(int amount) {
        paymentStrategy.pay(amount);
    }

}
