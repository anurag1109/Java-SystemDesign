package lld2.designPattern.behavioralDP.mediator;

import java.util.ArrayList;
import java.util.List;

public class Auction implements AuctionMediator {

    private List<Collegue> bidders = new ArrayList<>();

    @Override
    public void addBidder(Collegue bidder) {
        bidders.add(bidder);
        // Logic to add a bidder to the auction
        System.out.println(bidder.getName() + " has joined the auction.");
    }

    @Override
    public void placeBid(Collegue bidder, double amount) {
        // Logic to handle bid placement
        for (Collegue b : bidders) {
            if (b != bidder) {
                b.receiveMessage("New bid placed by " + bidder.getName() + ": " + amount);
            }
        }
    }

}
