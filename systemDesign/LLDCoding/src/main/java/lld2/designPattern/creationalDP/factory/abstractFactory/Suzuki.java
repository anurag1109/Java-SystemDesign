package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * Suzuki - Ordinary vehicle implementation
 * Budget-friendly, compact car with affordable price
 */
public class Suzuki implements Vehicle {

    @Override
    public void displayInfo() {
        System.out.println("🚗 SUZUKI - Compact Budget Car");
        System.out.println("   Type: Sedan/Hatchback");
        System.out.println("   Category: ORDINARY");
        System.out.println("   Features: Small, compact, fuel efficient, low maintenance");
        System.out.println("   Price: $12,000 - $20,000");
    }

    @Override
    public String getType() {
        return "Suzuki (Ordinary)";
    }

    @Override
    public double getPrice() {
        return 15000.0; // $15,000 average price
    }
}
