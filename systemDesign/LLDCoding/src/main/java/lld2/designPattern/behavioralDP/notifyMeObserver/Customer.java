package lld2.designPattern.behavioralDP.notifyMeObserver;

/**
 * Customer Class - Concrete Observer
 * 
 * This class represents a customer who wants to be notified
 * when a product becomes available
 */
public class Customer implements Observer {
    private String customerId;
    private String customerName;
    private String email;

    // Constructor
    public Customer(String customerId, String customerName, String email) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.email = email;
    }

    /**
     * Called when the product is back in stock
     * This method receives the notification
     * 
     * @param product - the product that became available
     */
    @Override
    public void update(Product product) {
        sendNotification(product);
    }

    /**
     * Send notification to customer
     * In a real system, this would send email/SMS/push notification
     */
    private void sendNotification(Product product) {
        System.out.println("📧 Email Notification to: " + customerName + " (" + email + ")");
        System.out.println("   Message: '" + product.getProductName() + "' is now back in stock!");
        System.out.println("   Quantity: " + product.getStockQuantity() + " units available\n");
    }

    // Getters
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return customerName + " (" + email + ")";
    }
}
