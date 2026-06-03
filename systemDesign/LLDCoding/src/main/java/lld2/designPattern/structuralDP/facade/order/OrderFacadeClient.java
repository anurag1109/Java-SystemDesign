package lld2.designPattern.structuralDP.facade.order;

/**
 * OrderFacadeClient - Demonstrates the Facade Pattern
 * 
 * CLIENT ONLY NEEDS TO USE THE FACADE - OrderFacade
 * Client doesn't need to know about ProductDAO, Payment, Invoice, or
 * SendNotification
 * 
 * This is the POWER of Facade Pattern!
 */
public class OrderFacadeClient {

    public static void main(String[] args) {
        System.out.println("\n════════════════════════════════════════════════════════════");
        System.out.println("       FACADE DESIGN PATTERN - E-COMMERCE ORDER SYSTEM");
        System.out.println("════════════════════════════════════════════════════════════\n");

        // Create facade instance
        OrderFacade orderFacade = new OrderFacade();

        System.out.println("WITHOUT FACADE:");
        System.out.println("❌ Client would need to manually call:");
        System.out.println("   1. productDAO.getProduct()");
        System.out.println("   2. payment.makePayment()");
        System.out.println("   3. invoice.generateInvoice()");
        System.out.println("   4. notification.sendNotification()");
        System.out.println("   → Complex and error-prone!\n");

        System.out.println("WITH FACADE:");
        System.out.println("✓ Client simply calls: orderFacade.createOrder(productId)");
        System.out.println("   → All complex steps handled internally!\n");

        // ============================================================
        // CLIENT CODE - Very Simple!
        // ============================================================

        // Example 1: Order Laptop
        orderFacade.createOrder("P001");

        // Example 2: Order Mobile
        orderFacade.createOrder("P002");

        // Example 3: Order Headphones
        orderFacade.createOrder("P003");

        // Example 4: Order non-existent product
        orderFacade.createOrder("P999");

        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("       BENEFITS OF FACADE PATTERN:");
        System.out.println("════════════════════════════════════════════════════════════");
        System.out.println("✓ Simple Interface - Client only calls createOrder()");
        System.out.println("✓ Hides Complexity - All steps hidden inside facade");
        System.out.println("✓ Loose Coupling - Client doesn't know about subsystems");
        System.out.println("✓ Easy to Maintain - Changes only inside facade");
        System.out.println("✓ Easy to Test - Can mock facade for testing");
        System.out.println("════════════════════════════════════════════════════════════\n");
    }
}
