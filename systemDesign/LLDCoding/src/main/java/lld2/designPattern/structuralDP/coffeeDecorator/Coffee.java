package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * Coffee Interface - Defines contract for all coffee types
 * 
 * The Decorator pattern allows us to add features to objects dynamically
 * This interface represents the base "component" that decorators will wrap
 */
public interface Coffee {

    /**
     * @return The description of the coffee (what it contains)
     */
    String getDescription();

    /**
     * @return The cost of the coffee in rupees
     */
    double getCost();
}
