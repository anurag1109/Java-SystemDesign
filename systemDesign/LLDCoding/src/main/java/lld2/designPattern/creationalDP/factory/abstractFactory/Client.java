package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * Client - Demonstrates the Abstract Factory Pattern
 * 
 * Shows how to use different factories to create families of related products
 * without knowing the exact concrete classes
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("   ABSTRACT FACTORY PATTERN - VEHICLES");
        System.out.println("========================================\n");

        // ===== SCENARIO 1: Luxury Vehicle Buyer =====
        System.out.println("--- SCENARIO 1: Luxury Dealership ---\n");

        VehicleFactory luxuryFactory = new LuxuryVehicleFactory();
        System.out.println("Factory: " + luxuryFactory.getFactoryName());
        System.out.println();

        // Now using single createVehicle(String type) method - scalable for unlimited
        // vehicles!
        Vehicle bmw = luxuryFactory.createVehicle("BMW");
        Vehicle audi = luxuryFactory.createVehicle("AUDI");

        System.out.println("Vehicle 1:");
        bmw.displayInfo();
        System.out.println("   >> Price: $" + bmw.getPrice());
        System.out.println();

        System.out.println("Vehicle 2:");
        audi.displayInfo();
        System.out.println("   >> Price: $" + audi.getPrice());
        System.out.println();

        // ===== SCENARIO 2: Ordinary Vehicle Buyer =====
        System.out.println("--- SCENARIO 2: Budget Dealership ---\n");

        VehicleFactory ordinaryFactory = new OrdinaryVehicleFactory();
        System.out.println("Factory: " + ordinaryFactory.getFactoryName());
        System.out.println();

        // Now using single createVehicle(String type) method - scalable for unlimited
        // vehicles!
        Vehicle hyundai = ordinaryFactory.createVehicle("HYUNDAI");
        Vehicle suzuki = ordinaryFactory.createVehicle("SUZUKI");

        System.out.println("Vehicle 1:");
        hyundai.displayInfo();
        System.out.println("   >> Price: $" + hyundai.getPrice());
        System.out.println();

        System.out.println("Vehicle 2:");
        suzuki.displayInfo();
        System.out.println("   >> Price: $" + suzuki.getPrice());
        System.out.println();

        // ===== COMPARISON =====
        System.out.println("--- COMPARISON ---\n");
        System.out.println("Luxury Vehicles Total Price: $" + (bmw.getPrice() + audi.getPrice()));
        System.out.println("Ordinary Vehicles Total Price: $" + (hyundai.getPrice() + suzuki.getPrice()));
        System.out.println();
        System.out.println("Savings with Ordinary Vehicles: $" +
                ((bmw.getPrice() + audi.getPrice()) - (hyundai.getPrice() + suzuki.getPrice())));

        System.out.println("\n========================================");
        System.out.println("KEY BENEFITS OF ABSTRACT FACTORY:");
        System.out.println("========================================");
        System.out.println("✓ Client doesn't know concrete classes (BMW, Audi, etc.)");
        System.out.println("✓ Easy to switch between factories (Luxury ↔ Ordinary)");
        System.out.println("✓ Creates families of related objects together");
        System.out.println("✓ Easy to add new vehicle types or factories");
        System.out.println("========================================");
    }
}
