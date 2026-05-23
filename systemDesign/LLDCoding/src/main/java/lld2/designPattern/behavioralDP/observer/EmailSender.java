package lld2.designPattern.behavioralDP.observer;

public class EmailSender implements OrderPlacedSubscriber {

    public EmailSender() {
        Flipkart flipkart = Flipkart.getInstance();
        flipkart.registerSubscriber(this);
    }

    @Override
    public ReturnData announceOrderPlaced() {
        sendEmail();
        return new ReturnData();
    }

    public void sendEmail() {
        System.out.println("Sending Email");
    }
}
