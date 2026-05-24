package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * LuxuryVehicleFactory - Concrete Factory for Luxury Vehicles
 * This factory creates luxurious vehicles (BMW and Audi)
 * 
 * It implements the VehicleFactory interface and provides
 * implementations for creating luxury vehicles
 */
public class LuxuryVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(String vehicleType) {
        // Switch based on vehicle type - easily add more vehicles here!
        switch (vehicleType.toUpperCase()) {
            case "BMW":
                return new BMW();
            case "AUDI":
                return new Audi();
            case "MERCEDES":
                // Can easily add more luxury vehicles
                System.out.println("Creating Mercedes-Benz...");
                return new BMW(); // Placeholder
            case "ROLLS_ROYCE":
                System.out.println("Creating Rolls Royce...");
                return new Audi(); // Placeholder
            default:
                throw new IllegalArgumentException("Unknown luxury vehicle type: " + vehicleType);
        }
    }

    @Override
    public String getFactoryName() {
        return "LUXURY VEHICLE FACTORY";
    }
}
