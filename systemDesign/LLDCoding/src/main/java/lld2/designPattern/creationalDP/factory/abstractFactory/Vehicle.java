package lld2.designPattern.creationalDP.factory.abstractFactory;

/**
 * Vehicle Interface - defines the contract for all vehicles
 * This is what all concrete vehicles (BMW, Audi, Hyundai, Suzuki) will
 * implement
 */
public interface Vehicle {
    // Display vehicle details
    void displayInfo();

    // Get the vehicle type
    String getType();

    // Get the price
    double getPrice();
}
