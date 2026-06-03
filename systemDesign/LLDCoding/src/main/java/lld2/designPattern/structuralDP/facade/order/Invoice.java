package lld2.designPattern.structuralDP.facade.order;

/**
 * Invoice - Generates invoice for completed orders
 * Contains invoice generation logic
 */
public class Invoice {

    /**
     * Generates invoice for the given product
     */
    public void generateInvoice(Product product) {
        System.out.println("\n--- Invoice Generated ---");
        System.out.println("Invoice ID: INV-" + System.nanoTime());
        System.out.println("Product: " + product.getProductName());
        System.out.println("Price: ₹" + product.getPrice());
        System.out.println("Date: " + java.time.LocalDate.now());
        System.out.println("Status: Generated Successfully");
    }
}
