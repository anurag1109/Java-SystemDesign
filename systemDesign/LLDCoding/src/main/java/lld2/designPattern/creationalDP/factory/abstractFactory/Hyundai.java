package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * Hyundai - Ordinary vehicle implementation
 * Budget-friendly, reliable car with affordable price
 */
public class Hyundai implements Vehicle {

    @Override
    public void displayInfo() {
        System.out.println("🚗 HYUNDAI - Budget-Friendly Car");
        System.out.println("   Type: Sedan/Hatchback");
        System.out.println("   Category: ORDINARY");
        System.out.println("   Features: Fuel efficient, Spacious interior, Good warranty");
        System.out.println("   Price: $15,000 - $25,000");
    }

    @Override
    public String getType() {
        return "Hyundai (Ordinary)";
    }

    @Override
    public double getPrice() {
        return 18000.0; // $18,000 average price
    }
}
