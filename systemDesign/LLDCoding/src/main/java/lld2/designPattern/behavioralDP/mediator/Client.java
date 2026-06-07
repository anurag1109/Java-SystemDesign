package lld2.designPattern.behavioralDP.mediator;

public class Client {

    public static void main(String[] args) {
        AuctionMediator mediator = new Auction();

        Bidder bidder1 = new Bidder("Bidder 1", mediator);
        Bidder bidder2 = new Bidder("Bidder 2", mediator);
        Bidder bidder3 = new Bidder("Bidder 3", mediator);

        bidder1.placeBid(100);
        bidder2.placeBid(150);
        bidder3.placeBid(120);
    }

}
