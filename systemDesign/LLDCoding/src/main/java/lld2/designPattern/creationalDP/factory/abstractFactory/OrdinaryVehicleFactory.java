package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * OrdinaryVehicleFactory - Concrete Factory for Ordinary Vehicles
 * This factory creates budget-friendly vehicles (Hyundai and Suzuki)
 * 
 * It implements the VehicleFactory interface and provides
 * implementations for creating ordinary vehicles
 */
public class OrdinaryVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle createVehicle(String vehicleType) {
        // Switch based on vehicle type - easily add more vehicles here!
        switch (vehicleType.toUpperCase()) {
            case "HYUNDAI":
                return new Hyundai();
            case "SUZUKI":
                return new Suzuki();
            case "TATA":
                // Can easily add more ordinary vehicles
                System.out.println("Creating Tata...");
                return new Hyundai(); // Placeholder
            case "MARUTI":
                System.out.println("Creating Maruti...");
                return new Suzuki(); // Placeholder
            default:
                throw new IllegalArgumentException("Unknown ordinary vehicle type: " + vehicleType);
        }
    }

    @Override
    public String getFactoryName() {
        return "ORDINARY VEHICLE FACTORY";
    }
}
