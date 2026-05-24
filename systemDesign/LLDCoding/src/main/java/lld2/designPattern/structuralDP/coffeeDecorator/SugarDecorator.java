package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * SugarDecorator - Adds sugar to coffee
 */
public class SugarDecorator extends CoffeeDecorator {

    /**
     * Constructor - takes the coffee to decorate
     * 
     * @param coffee The coffee to add sugar to
     */
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    /**
     * Add sugar description to the wrapped coffee's description
     */
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription() + ", Sugar";
    }

    /**
     * Add sugar cost (Rs 5) to the wrapped coffee's cost
     */
    @Override
    public double getCost() {
        return wrappedCoffee.getCost() + 5.0;
    }
}
