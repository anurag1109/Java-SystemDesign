package lld2.designPattern.behavioralDP.weatherObserver;

/**
 * Observer Interface
 * 
 * This interface defines the contract for all observers (subscribers)
 * who want to be notified when a weather becomes available
 */
public interface Observer {

    /**
     * Update method - called when the observed weather changes
     * 
     * @param weather - the weather that has changed
     */
    void update(Weather weather);
}
