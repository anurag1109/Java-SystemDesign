package lld2.designPattern.behavioralDP.mediator;

public interface AuctionMediator {

    public void placeBid(Collegue bidder, double amount);

    public void addBidder(Collegue bidder);
}
