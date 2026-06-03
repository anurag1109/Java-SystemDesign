package lld2.designPattern.structuralDP.facade.order;

/**
 * ProductDAO - Data Access Object for fetching product details
 * This simulates database operations
 */
public class ProductDAO {

    /**
     * Simulates fetching product from database
     * In real application, this would query actual database
     */
    public Product getProduct(String productId) {
        System.out.println("ProductDAO: Fetching product " + productId + " from database...");

        // Simulating database lookup
        if ("P001".equals(productId)) {
            return new Product("P001", "Laptop", 50000);
        } else if ("P002".equals(productId)) {
            return new Product("P002", "Mobile", 25000);
        } else if ("P003".equals(productId)) {
            return new Product("P003", "Headphones", 5000);
        }

        return null;
    }
}
