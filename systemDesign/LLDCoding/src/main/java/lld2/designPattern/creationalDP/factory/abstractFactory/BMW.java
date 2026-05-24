package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * BMW - Luxury vehicle implementation
 * Premium luxury car with high price
 */
public class BMW implements Vehicle {

    @Override
    public void displayInfo() {
        System.out.println("🏎️  BMW - Premium Luxury Car");
        System.out.println("   Type: Sedan/SUV");
        System.out.println("   Category: LUXURY");
        System.out.println("   Features: Leather seats, Premium sound system, Advanced safety");
        System.out.println("   Price: $80,000 - $150,000");
    }

    @Override
    public String getType() {
        return "BMW (Luxury)";
    }

    @Override
    public double getPrice() {
        return 100000.0; // $100,000 average price
    }
}
