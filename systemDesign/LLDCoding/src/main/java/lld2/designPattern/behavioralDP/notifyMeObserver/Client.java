package lld2.designPattern.behavioralDP.notifyMeObserver;

/**
 * NotifyMeObserver Pattern - Client Demo
 * 
 * This demonstrates how the Observer pattern works for e-commerce "Notify Me"
 * feature
 * 
 * Scenario: A customer wants to be notified when an out-of-stock product
 * becomes available
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("========== NOTIFY ME OBSERVER PATTERN ==========\n");

        // Step 1: Create a product (Observable)
        Product iphone15 = new Product("P001", "iPhone 15", 0); // Out of stock
        System.out.println("✓ Product created: " + iphone15.getProductName());
        System.out.println("  Current Stock: " + iphone15.getStockQuantity() + " units\n");

        // Step 2: Create customers (Observers)
        Customer customer1 = new Customer("C001", "Amit Kumar", "amit@email.com");
        Customer customer2 = new Customer("C002", "Priya Singh", "priya@email.com");
        Customer customer3 = new Customer("C003", "Rajesh Patel", "rajesh@email.com");

        System.out.println("✓ Customers created:\n");

        // Step 3: Customers subscribe to product notifications (Register Observers)
        System.out.println("--- Customers subscribing to Notify Me ---");
        iphone15.registerObserver(customer1);
        iphone15.registerObserver(customer2);
        iphone15.registerObserver(customer3);

        // Step 4: Create notification service (Another Observer)
        NotificationService analyticsService = new NotificationService("SVC001", "Analytics Service");
        System.out.println();
        iphone15.registerObserver(analyticsService);

        // Step 5: Product goes out of stock (simulate selling all units)
        System.out.println("\n--- Product runs out of stock ---");
        iphone15.sellProduct(50); // Sell some units (simulated previous sales)

        // Step 6: Product is restocked - THIS TRIGGERS NOTIFICATIONS TO ALL OBSERVERS
        System.out.println("\n--- Product Restock: Back in Stock! ---");
        iphone15.restock(100); // Add stock - this will notify all observers

        System.out.println("\n========== SECOND PRODUCT DEMO ==========\n");

        // Create another product scenario
        Product ps5 = new Product("P002", "PlayStation 5", 0);
        System.out.println("✓ Product created: " + ps5.getProductName() + " (Stock: " + ps5.getStockQuantity() + ")\n");

        // Different customers
        Customer customer4 = new Customer("C004", "Vikram Sharma", "vikram@email.com");
        Customer customer5 = new Customer("C005", "Neha Gupta", "neha@email.com");

        System.out.println("--- Customers subscribing for PS5 ---");
        ps5.registerObserver(customer4);
        ps5.registerObserver(customer5);

        System.out.println("\n--- PS5 Restock ---");
        ps5.restock(50);

        System.out.println("\n========== KEY CONCEPTS ==========");
        System.out.println("✓ Observable (Subject): Product class");
        System.out.println("✓ Observer: Customer and NotificationService");
        System.out.println("✓ Benefit: Loose coupling - Product doesn't need to know about observers");
        System.out.println("✓ Extensible: Can add new observer types without modifying Product\n");
    }
}
