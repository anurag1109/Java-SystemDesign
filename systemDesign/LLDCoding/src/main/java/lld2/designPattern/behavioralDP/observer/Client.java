package lld2.designPattern.behavioralDP.observer;

public class Client {

    public static void main(String[] args) {
        // only one instance of Flipkart should be there => singleton pattern
        Flipkart flipkart = Flipkart.getInstance();
        // add subscribers

        // we can subscribe manually if subscription logic is not written in constructor
        // function of subscriber class
        // OrderPlacedSubscriber emailSender = new EmailSender();
        // flipkart.registerSubscriber(emailSender);

        EmailSender emailSender = new EmailSender();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        AnalyticsSender analyticsSender = new AnalyticsSender();

        flipkart.orderPlaced();
    }
}
