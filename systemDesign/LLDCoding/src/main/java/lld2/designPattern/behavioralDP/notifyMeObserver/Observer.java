package lld2.designPattern.behavioralDP.notifyMeObserver;

/**
 * Observer Interface
 * 
 * This interface defines the contract for all observers (subscribers)
 * who want to be notified when a product becomes available
 */
public interface Observer {

    /**
     * Update method - called when the observed product changes
     * 
     * @param product - the product that has changed
     */
    void update(Product product);
}
