package lld2.designPattern.behavioralDP.notifyMeObserver;

/**
 * NotificationService - Concrete Observer
 * 
 * This is an advanced observer that sends notifications through multiple
 * channels
 * Shows how the Observer pattern allows different types of observers
 */
public class NotificationService implements Observer {
    private String serviceId;
    private String serviceName;

    // Constructor
    public NotificationService(String serviceId, String serviceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    /**
     * Called when the product is back in stock
     * This service can generate reports, update analytics, etc.
     */
    @Override
    public void update(Product product) {
        sendNotification(product);
    }

    /**
     * Send notification through the service
     */
    private void sendNotification(Product product) {
        System.out.println("📊 " + serviceName + " Report:");
        System.out.println("   Product: " + product.getProductName());
        System.out.println("   Status: BACK IN STOCK");
        System.out.println("   Current Stock: " + product.getStockQuantity() + " units\n");
    }

    @Override
    public String toString() {
        return serviceName;
    }
}
