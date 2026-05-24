package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * ChocolateDecorator - Adds chocolate to coffee
 */
public class ChocolateDecorator extends CoffeeDecorator {

    /**
     * Constructor - takes the coffee to decorate
     * 
     * @param coffee The coffee to add chocolate to
     */
    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }

    /**
     * Add chocolate description to the wrapped coffee's description
     */
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Chocolate";
    }

    /**
     * Add chocolate cost (Rs 30) to the wrapped coffee's cost
     */
    @Override
    public double getCost() {
        return wrappedCoffee.getCost() + 30.0;
    }
}
