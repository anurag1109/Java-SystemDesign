package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * SimpleCoffee - The base/concrete component
 * 
 * This is the original object to which we'll add features using decorators
 * It implements the Coffee interface directly
 */
public class SimpleCoffee implements Coffee {

    /**
     * Base coffee description - just plain coffee
     */
    @Override
    public String getDescription() {
        return "Plain Coffee";
    }

    /**
     * Base coffee cost - Rs 50
     */
    @Override
    public double getCost() {
        return 50.0;
    }
}
