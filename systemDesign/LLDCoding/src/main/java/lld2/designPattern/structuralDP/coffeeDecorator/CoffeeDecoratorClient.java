package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * CoffeeDecoratorClient - Demonstrates the Decorator Pattern with Coffee
 * 
 * What is Decorator Pattern?
 * - It allows us to add new features to objects dynamically
 * - Without modifying the original object or creating new classes for each
 * combination
 * - We wrap objects with decorators that add functionality
 * 
 * Real-world example:
 * At a coffee shop, you can order:
 * - Plain Coffee
 * - Coffee with Milk
 * - Coffee with Milk and Sugar
 * - Coffee with Milk, Sugar, and Chocolate
 * Each addition wraps the previous order and adds cost
 */
public class CoffeeDecoratorClient {

        public static void main(String[] args) {
                System.out.println("===== COFFEE DECORATOR PATTERN =====\n");

                // EXAMPLE 1: Plain Coffee (No decorators)
                System.out.println("--- EXAMPLE 1: Plain Coffee ---");
                Coffee simpleCoffee = new SimpleCoffee();
                System.out.println("Description: " + simpleCoffee.getDescription());
                System.out.println("Cost: Rs " + simpleCoffee.getCost());
                System.out.println();

                // EXAMPLE 2: Coffee with Milk (1 decorator)
                System.out.println("--- EXAMPLE 2: Coffee + Milk ---");
                Coffee coffeeWithMilk = new MilkDecorator(new SimpleCoffee());
                System.out.println("Description: " + coffeeWithMilk.getDescription());
                System.out.println("Cost: Rs " + coffeeWithMilk.getCost());
                System.out.println();

                // EXAMPLE 3: Coffee with Milk and Sugar (2 decorators)
                System.out.println("--- EXAMPLE 3: Coffee + Milk + Sugar ---");
                Coffee coffeeWithMilkAndSugar = new SugarDecorator(
                                new MilkDecorator(
                                                new SimpleCoffee()));
                System.out.println("Description: " + coffeeWithMilkAndSugar.getDescription());
                System.out.println("Cost: Rs " + coffeeWithMilkAndSugar.getCost());
                System.out.println();

                // EXAMPLE 4: Coffee with all toppings (3 decorators)
                System.out.println("--- EXAMPLE 4: Coffee + Milk + Sugar + Chocolate ---");
                Coffee coffeeWithAllToppings = new ChocolateDecorator(
                                new SugarDecorator(
                                                new MilkDecorator(
                                                                new SimpleCoffee())));
                System.out.println("Description: " + coffeeWithAllToppings.getDescription());
                System.out.println("Cost: Rs " + coffeeWithAllToppings.getCost());
                System.out.println();

                // EXAMPLE 5: Different combination - Chocolate + Milk (decorators can be in any
                // order)
                System.out.println("--- EXAMPLE 5: Coffee + Chocolate + Milk ---");
                Coffee coffeeChocolateMilk = new MilkDecorator(
                                new ChocolateDecorator(
                                                new SimpleCoffee()));
                System.out.println("Description: " + coffeeChocolateMilk.getDescription());
                System.out.println("Cost: Rs " + coffeeChocolateMilk.getCost());
                System.out.println();

                // EXAMPLE 6: Multiple of same decorator
                System.out.println("--- EXAMPLE 6: Coffee + 2x Milk (Double Milk) ---");
                Coffee coffeeDoubleMilk = new MilkDecorator(
                                new MilkDecorator(
                                                new SimpleCoffee()));
                System.out.println("Description: " + coffeeDoubleMilk.getDescription());
                System.out.println("Cost: Rs " + coffeeDoubleMilk.getCost());
                System.out.println();

                // BENEFITS OF DECORATOR PATTERN:
                System.out.println("===== BENEFITS =====");
                System.out.println("1. No need to create classes like CoffeeWithMilkAndSugar");
                System.out.println("2. Easy to add new decorators (just extend CoffeeDecorator)");
                System.out.println("3. Can combine decorators in any order");
                System.out.println("4. Original SimpleCoffee class is never modified");
                System.out.println("5. Open/Closed Principle: Open for extension, closed for modification");
        }
}
