package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * VehicleFactory - Abstract Factory Interface
 * Defines the contract for creating vehicles (both luxury and ordinary)
 * 
 * This is the key to Abstract Factory Pattern!
 * Each concrete factory will implement this to create its own family of
 * products.
 */
public interface VehicleFactory {

    /**
     * Creates a vehicle based on the type provided
     * This method replaces createVehicle1() and createVehicle2()
     * Now you can create unlimited vehicles just by passing the type!
     * 
     * @param vehicleType - Type of vehicle to create (e.g., "BMW", "AUDI",
     *                    "HYUNDAI", "SUZUKI")
     * @return Vehicle object of the requested type
     */
    Vehicle createVehicle(String vehicleType);

    // Get factory name
    String getFactoryName();
}
