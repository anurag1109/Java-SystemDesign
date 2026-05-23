package lld1.SOLID;

import java.util.ArrayList;
import java.util.List;

/**
 * LISKOV SUBSTITUTION PRINCIPLE (LSP)
 * 
 * Definition: Objects of a superclass should be replaceable with objects of its subclasses 
 * without breaking the application or causing unexpected behavior.
 * 
 * In other words: If Bike is a Vehicle, then Bike should behave like a Vehicle in all scenarios.
 * 
 * Key Points:
 * 1. Subclasses must be substitutable for their parent classes
 * 2. Subclass behavior must not violate parent class contract
 * 3. Subclass should not throw exceptions not thrown by parent
 * 4. Subclass should not change the meaning of parent's methods
 * 
 * Benefits:
 * - Predictable behavior when using polymorphism
 * - Code works with any subclass without modification
 * - Reduces bugs from unexpected behavior
 */

// ============================================================================
// BAD EXAMPLE: Violating Liskov Substitution Principle
// ============================================================================

/**
 * Vehicle - Base class defining the contract
 * All vehicles should start and stop smoothly
 */
abstract class VehicleBad {
    abstract void start();

    abstract void stop();

    abstract int getSpeed();
}

/**
 * Bike - Extends Vehicle and honors the contract
 * Normal behavior
 */
class BikeBad extends VehicleBad {
    private boolean isRunning = false;
    private int speed = 0;

    @Override
    public void start() {
        isRunning = true;
        System.out.println("🚲 Bike started smoothly");
    }

    @Override
    public void stop() {
        speed = 0;
        isRunning = false;
        System.out.println("🚲 Bike stopped smoothly");
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}

/**
 * Bicycle - Also extends Vehicle but VIOLATES LSP
 * Problem: Bicycle doesn't have a "start()" or "stop()" method in real life
 * But it's forced to implement them, and the behavior is strange
 * 
 * This violates LSP because:
 * - Client code expects start() to actually start something
 * - But for bicycle, start() doesn't make sense
 * - Behavior is inconsistent with the Vehicle contract
 */
class BicycleBad extends VehicleBad {
    private int speed = 0;

    @Override
    public void start() {
        // This doesn't make sense for a bicycle!
        System.out.println("⚠️ ERROR: Bicycle can't be 'started' - it has no engine!");
        throw new UnsupportedOperationException("Bicycles don't start");
    }

    @Override
    public void stop() {
        System.out.println("⚠️ ERROR: Bicycle doesn't 'stop' like motorized vehicles");
        throw new UnsupportedOperationException("Bicycles don't stop like that");
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}

/**
 * This function demonstrates the LSP violation
 * Code expects all Vehicles to behave the same way
 */
class VehicleTestBad {
    public static void testVehicle(VehicleBad vehicle) {
        try {
            vehicle.start(); // Works for Bike but throws exception for Bicycle!
            System.out.println("Speed: " + vehicle.getSpeed());
            vehicle.stop();
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("LSP VIOLATED! Not all vehicles can be treated the same way!\n");
        }
    }
}

// ============================================================================
// GOOD EXAMPLE: Following Liskov Substitution Principle
// ============================================================================

/**
 * Vehicle - Base contract that all vehicles must honor
 */
abstract class Vehicle {
    abstract void start();

    abstract void stop();

    abstract int getSpeed();

    abstract String getType();
}

/**
 * Bike - Properly implements Vehicle contract
 * Has a motor, can start and stop
 */
class Bike extends Vehicle {
    private boolean isRunning = false;
    private int speed = 0;

    @Override
    public void start() {
        isRunning = true;
        System.out.println("✅ Bike engine started - VROOM!");
    }

    @Override
    public void stop() {
        speed = 0;
        isRunning = false;
        System.out.println("✅ Bike stopped safely");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getType() {
        return "Motorbike";
    }

    public void accelerate() {
        if (isRunning) {
            speed += 20;
            System.out.println("🚙 Bike accelerated to " + speed + " km/h");
        }
    }
}

/**
 * Car - Also properly implements Vehicle contract
 * Has a motor, can start and stop
 */
class Car extends Vehicle {
    private boolean isRunning = false;
    private int speed = 0;

    @Override
    public void start() {
        isRunning = true;
        System.out.println("✅ Car engine started - Engine running");
    }

    @Override
    public void stop() {
        speed = 0;
        isRunning = false;
        System.out.println("✅ Car stopped safely");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getType() {
        return "Car";
    }

    public void accelerate() {
        if (isRunning) {
            speed += 15;
            System.out.println("🏎️ Car accelerated to " + speed + " km/h");
        }
    }
}

/**
 * Truck - Also properly implements Vehicle contract
 * Has a motor, can start and stop
 */
class Truck extends Vehicle {
    private boolean isRunning = false;
    private int speed = 0;

    @Override
    public void start() {
        isRunning = true;
        System.out.println("✅ Truck engine started - Heavy engine running");
    }

    @Override
    public void stop() {
        speed = 0;
        isRunning = false;
        System.out.println("✅ Truck stopped with air brakes");
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getType() {
        return "Truck";
    }

    public void accelerate() {
        if (isRunning) {
            speed += 10; // Trucks accelerate slower
            System.out.println("🚚 Truck accelerated to " + speed + " km/h");
        }
    }
}

/**
 * Bicycle - Does NOT extend Vehicle
 * Bicycle should NOT be treated like a motorized vehicle
 * This follows LSP by using a different interface for non-motorized vehicles
 */
interface HumanPoweredVehicle {
    void pedal();

    void brake();

    int getSpeed();
}

class Bicycle implements HumanPoweredVehicle {
    private int speed = 0;

    @Override
    public void pedal() {
        speed += 10;
        System.out.println("🚴 Bicycle pedaled - speed increased to " + speed + " km/h");
    }

    @Override
    public void brake() {
        speed = 0;
        System.out.println("🚴 Bicycle braked and stopped");
    }

    @Override
    public int getSpeed() {
        return speed;
    }
}

/**
 * VehicleGarage - Works with any Vehicle
 * All vehicles can be treated uniformly because they honor the contract
 */
class VehicleGarage {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Start all vehicles
     * This works because ALL Vehicle implementations honor the contract
     */
    public void startAllVehicles() {
        System.out.println("\n--- Starting All Vehicles ---");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Starting " + vehicle.getType() + ":");
            vehicle.start();
        }
    }

    /**
     * Stop all vehicles
     * This works because ALL Vehicle implementations honor the contract
     */
    public void stopAllVehicles() {
        System.out.println("\n--- Stopping All Vehicles ---");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Stopping " + vehicle.getType() + ":");
            vehicle.stop();
        }
    }

    /**
     * Get total number of vehicles
     */
    public int getTotalVehicles() {
        return vehicles.size();
    }
}

/**
 * TrafficController - Works with any Vehicle
 * Can manage any vehicle without special cases
 */
class TrafficController {
    /**
     * Process vehicle - ANY Vehicle can be processed
     * No instanceof checks, no casting needed
     * This demonstrates LSP in action
     */
    public void processVehicle(Vehicle vehicle) {
        System.out.println("\nProcessing: " + vehicle.getType());
        System.out.println("Current Speed: " + vehicle.getSpeed() + " km/h");

        vehicle.start();

        if (vehicle instanceof Bike) {
            ((Bike) vehicle).accelerate();
        } else if (vehicle instanceof Car) {
            ((Car) vehicle).accelerate();
        } else if (vehicle instanceof Truck) {
            ((Truck) vehicle).accelerate();
        }

        vehicle.stop();
    }

    /**
     * Check if vehicle is safe to go
     * Works with ANY Vehicle implementation
     */
    public boolean isSafeToGo(Vehicle vehicle) {
        return vehicle.getSpeed() < 100;
    }
}

// ============================================================================
// CLIENT: Demonstrating Liskov Substitution Principle
// ============================================================================

public class LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║      Liskov Substitution Principle - Vehicle Example          ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        // ===== BAD EXAMPLE: LSP Violation =====
        System.out.println("\n❌ BAD EXAMPLE: LSP Violation\n");
        System.out.println("Testing Bike (works fine):");
        VehicleTestBad.testVehicle(new BikeBad());

        System.out.println("\nTesting Bicycle (FAILS - LSP Violated):");
        VehicleTestBad.testVehicle(new BicycleBad());

        // ===== GOOD EXAMPLE: LSP Compliance =====
        System.out.println("\n✅ GOOD EXAMPLE: LSP Compliance\n");

        // Create garage and add different vehicles
        VehicleGarage garage = new VehicleGarage();
        garage.addVehicle(new Bike());
        garage.addVehicle(new Car());
        garage.addVehicle(new Truck());

        System.out.println("Total vehicles in garage: " + garage.getTotalVehicles());

        // Start all vehicles
        garage.startAllVehicles();

        // Stop all vehicles
        garage.stopAllVehicles();

        // ===== Traffic Controller =====
        System.out.println("\n--- Traffic Controller Operations ---");
        TrafficController controller = new TrafficController();

        controller.processVehicle(new Bike());
        controller.processVehicle(new Car());
        controller.processVehicle(new Truck());

        // ===== Bicycle (Non-motorized) =====
        System.out.println("\n--- Bicycle (Separate from Vehicle) ---");
        System.out.println("Notice: Bicycle uses HumanPoweredVehicle interface");
        System.out.println("This follows LSP by NOT forcing Bicycle into Vehicle hierarchy\n");

        Bicycle bicycle = new Bicycle();
        bicycle.pedal();
        bicycle.pedal();
        System.out.println("Bicycle speed: " + bicycle.getSpeed() + " km/h");
        bicycle.brake();

        // ===== Demonstrating Substitutability =====
        System.out.println("\n--- Demonstrating Perfect Substitutability ---");
        List<Vehicle> allVehicles = new ArrayList<>();
        allVehicles.add(new Bike());
        allVehicles.add(new Car());
        allVehicles.add(new Truck());

        System.out.println("All vehicles work perfectly in a list:");
        for (Vehicle v : allVehicles) {
            System.out.println("  • " + v.getType() + " can be started and stopped");
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                       KEY INSIGHTS                            ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

        System.out.println("\n❌ BAD: Bicycle extending Vehicle");
        System.out.println("   └─ Violates LSP: start() and stop() don't make sense");
        System.out.println("   └─ Throws exceptions when used as Vehicle");
        System.out.println("   └─ Code expecting Vehicle behavior breaks");

        System.out.println("\n✅ GOOD: Bike, Car, Truck all extend Vehicle");
        System.out.println("   └─ All honor the Vehicle contract");
        System.out.println("   └─ Can be substituted interchangeably");
        System.out.println("   └─ Code works with any Vehicle subclass");

        System.out.println("\n✅ BETTER: Bicycle implements HumanPoweredVehicle");
        System.out.println("   └─ Doesn't pretend to be a motorized vehicle");
        System.out.println("   └─ Separate interface for human-powered vehicles");
        System.out.println("   └─ Clear separation of concerns");

        System.out.println("\n📌 Conclusion:");
        System.out.println("   When you find a subclass that doesn't honor the parent's contract,");
        System.out.println("   it's a sign that LSP is being violated. Use a different interface!");
    }
}
