package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * Audi - Luxury vehicle implementation
 * Premium luxury car with high price
 */
public class Audi implements Vehicle {

    @Override
    public void displayInfo() {
        System.out.println("🏎️  AUDI - Premium Luxury Car");
        System.out.println("   Type: Sedan/SUV");
        System.out.println("   Category: LUXURY");
        System.out.println("   Features: Quattro AWD, LED headlights, Luxurious interior");
        System.out.println("   Price: $70,000 - $140,000");
    }

    @Override
    public String getType() {
        return "Audi (Luxury)";
    }

    @Override
    public double getPrice() {
        return 90000.0; // $90,000 average price
    }
}
