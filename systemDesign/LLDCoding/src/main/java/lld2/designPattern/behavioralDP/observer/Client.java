package lld2.designPattern.behavioralDP.observer;

public class Client {

    public static void main(String[] args) {
        Flipkart flipkart = Flipkart.getInstance();
        // add subscribers
        EmailSender emailSender = new EmailSender();
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        AnalyticsSender analyticsSender = new AnalyticsSender();

        flipkart.orderPlaced();
    }
}
