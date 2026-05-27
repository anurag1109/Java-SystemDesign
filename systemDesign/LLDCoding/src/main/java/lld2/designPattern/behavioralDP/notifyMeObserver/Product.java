package lld2.designPattern.behavioralDP.notifyMeObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Product Class - Observable (Subject)
 * 
 * This class represents a product and manages its observers (subscribers)
 * When stock becomes available, it notifies all registered observers
 */
public class Product {
    private String productId;
    private String productName;
    private int stockQuantity;
    private List<Observer> observers; // List of observers to notify
    
    // Constructor
    public Product(String productId, String productName, int stockQuantity) {
        this.productId = productId;
        this.productName = productName;
        this.stockQuantity = stockQuantity;
        this.observers = new ArrayList<>();
    }
    
    // Observer Management Methods
    
    /**
     * Register an observer to be notified when product becomes available
     * @param observer - the observer to add
     */
    public void registerObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("✓ Observer registered for: " + productName);
        }
    }
    
    /**
     * Remove an observer from the notification list
     * @param observer - the observer to remove
     */
    public void removeObserver(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("✓ Observer unregistered from: " + productName);
        }
    }
    
    /**
     * Notify all observers about product availability
     * This is called when stock is added
     */
    private void notifyObservers() {
        System.out.println("\n📢 Notifying " + observers.size() + " observers about " + productName + "...");
        for (Observer observer : observers) {
            observer.update(this);
        }
        // Clear observers after notification
        observers.clear();
    }
    
    // Business Logic Methods
    
    /**
     * Add stock to the product and notify observers if it was out of stock
     * @param quantity - quantity to add
     */
    public void restock(int quantity) {
        if (stockQuantity == 0 && quantity > 0) {
            // Product was out of stock, now it's back!
            stockQuantity += quantity;
            System.out.println("\n🔄 Product back in stock: " + productName + " (Quantity: " + stockQuantity + ")");
            notifyObservers(); // Notify all waiting customers
        } else {
            stockQuantity += quantity;
            System.out.println("\n📦 Stock added to " + productName + " (New Quantity: " + stockQuantity + ")");
        }
    }
    
    /**
     * Sell/Reduce stock
     * @param quantity - quantity to sell
     */
    public void sellProduct(int quantity) {
        if (stockQuantity >= quantity) {
            stockQuantity -= quantity;
            System.out.println("✓ Sold " + quantity + " units of " + productName + " (Remaining: " + stockQuantity + ")");
        } else {
            System.out.println("✗ Not enough stock! Available: " + stockQuantity);
        }
    }
    
    /**
     * Get the current stock quantity
     */
    public int getStockQuantity() {
        return stockQuantity;
    }
    
    /**
     * Check if product is in stock
     */
    public boolean isInStock() {
        return stockQuantity > 0;
    }
    
    // Getters
    public String getProductId() {
        return productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    @Override
    public String toString() {
        return productName + " (Stock: " + stockQuantity + ")";
    }
}
