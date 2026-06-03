package lld2.designPattern.structuralDP.facade.order;

/**
 * Payment - Handles payment processing
 * Contains payment processing logic and verification
 */
public class Payment {

    /**
     * Processes payment for the order
     */
    public void makePayment(Product product) {
        System.out.println("\n--- Payment Processing ---");
        System.out.println("Processing payment for: " + product.getProductName());
        System.out.println("Amount: ₹" + product.getPrice());

        // Simulate payment processing
        try {
            Thread.sleep(500); // Simulate processing delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("✓ Payment Successful");
        System.out.println("Transaction ID: TXN-" + System.nanoTime());
    }
}
