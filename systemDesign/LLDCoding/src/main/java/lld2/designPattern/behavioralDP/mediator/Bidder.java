package lld2.designPattern.behavioralDP.mediator;

public class Bidder implements Collegue {

    private String name;
    private AuctionMediator mediator;

    public Bidder(String name, AuctionMediator mediator) {
        this.name = name;
        this.mediator = mediator;
        mediator.addBidder(this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }

    @Override
    public void placeBid(double amount) {
        mediator.placeBid(this, amount);
    }

    public String getName() {
        return name;
    }
}
