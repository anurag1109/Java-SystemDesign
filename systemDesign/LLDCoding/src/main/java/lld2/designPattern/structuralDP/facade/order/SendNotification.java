package lld2.designPattern.structuralDP.facade.order;

/**
 * SendNotification - Sends notification to customers
 * Notifies customer about order placement and confirmation
 */
public class SendNotification {

    /**
     * Sends notification after successful order placement
     */
    public void sendNotification() {
        System.out.println("\n--- Sending Notification ---");
        System.out.println("📧 Email sent to customer");
        System.out.println("📱 SMS sent to customer");
        System.out.println("🔔 Push notification sent");
        System.out.println("✓ Notification Sent Successfully");
    }
}
