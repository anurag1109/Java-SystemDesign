package lld2.designPattern.structuralDP.facade.order;

/**
 * OrderFacade - THE FACADE
 * 
 * This is the main facade that simplifies the complex order creation process.
 * Instead of client calling multiple classes, client just calls createOrder()
 * 
 * It manages:
 * 1. ProductDAO - Fetch product details
 * 2. Payment - Process payment
 * 3. Invoice - Generate invoice
 * 4. SendNotification - Send notification
 */
public class OrderFacade {
    
    // Private instances of subsystem classes
    private ProductDAO productDAO;
    private Invoice invoice;
    private Payment payment;
    private SendNotification notification;

    /**
     * Constructor - Initialize all subsystem classes
     */
    public OrderFacade() {
        this.productDAO = new ProductDAO();
        this.invoice = new Invoice();
        this.payment = new Payment();
        this.notification = new SendNotification();
    }

    /**
     * THE MAIN METHOD - This is what client calls
     * Simplifies the entire order creation process into one method
     * 
     * Steps:
     * 1. Fetch product from database
     * 2. Process payment
     * 3. Generate invoice
     * 4. Send notification
     */
    public void createOrder(String productId) {
        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("║   STARTING ORDER CREATION        ║");
        System.out.println("╚═══════════════════════════════════╝");

        // Step 1: Fetch product from database
        Product product = productDAO.getProduct(productId);
        
        if (product == null) {
            System.out.println("❌ Product not found!");
            return;
        }

        System.out.println("✓ Product Found: " + product.getProductName());

        // Step 2: Process payment
        payment.makePayment(product);

        // Step 3: Generate invoice
        invoice.generateInvoice(product);

        // Step 4: Send notification
        notification.sendNotification();

        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("║   ORDER CREATED SUCCESSFULLY ✓    ║");
        System.out.println("╚═══════════════════════════════════╝\n");
    }
}
