package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * MilkDecorator - Adds milk to coffee
 * 
 * Example of a concrete decorator:
 * - Extends CoffeeDecorator (gets the wrappedCoffee reference)
 * - Overrides getDescription() to add "Milk"
 * - Overrides getCost() to add milk cost
 */
public class MilkDecorator extends CoffeeDecorator {

    /**
     * Constructor - takes the coffee to decorate and wraps it
     * 
     * @param coffee The coffee to add milk to
     */
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    /**
     * Add milk description to the wrapped coffee's description
     */
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Milk";
    }

    /**
     * Add milk cost (Rs 20) to the wrapped coffee's cost
     */
    @Override
    public double getCost() {
        return wrappedCoffee.getCost() + 20.0;
    }
}
