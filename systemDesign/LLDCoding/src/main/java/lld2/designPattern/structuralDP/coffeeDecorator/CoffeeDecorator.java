package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * CoffeeDecorator - Abstract decorator class
 * 
 * Key Points:
 * 1. It implements Coffee interface (so it can be used wherever Coffee is
 * expected)
 * 2. It has a reference to a Coffee object (the object being decorated)
 * 3. Subclasses will override getDescription() and getCost() to add their own
 * features
 * 
 * How it works:
 * - Decorators wrap the original object
 * - They add functionality while maintaining the same interface
 * - Multiple decorators can be chained together
 */
public abstract class CoffeeDecorator implements Coffee {

    // The wrapped coffee object
    protected Coffee wrappedCoffee;

    /**
     * Constructor - takes the coffee to be decorated
     * 
     * @param coffee The coffee object to decorate
     */
    public CoffeeDecorator(Coffee coffee) {
        this.wrappedCoffee = coffee;
    }

    /**
     * By default, return the wrapped coffee's description
     * Subclasses will override this to add their own description
     */
    @Override
    public String getDescription() {
        return wrappedCoffee.getDescription();
    }

    /**
     * By default, return the wrapped coffee's cost
     * Subclasses will override this to add their own cost
     */
    @Override
    public double getCost() {
        return wrappedCoffee.getCost();
    }
}
