package lld2.designPattern.structuralDP.coffeeDecorator;

/**
 * DECORATOR PATTERN - BEGINNER'S GUIDE
 * 
 * ============================================================================
 * WHAT IS DECORATOR PATTERN?
 * ============================================================================
 * The Decorator pattern allows you to add new features to objects dynamically
 * without modifying the original object's code.
 * 
 * Think of it like decorating a birthday cake:
 * - Start with plain cake
 * - Add chocolate frosting (decorator)
 * - Add sprinkles (another decorator)
 * - Add candles (another decorator)
 * 
 * Each decoration wraps the previous item but doesn't change the original cake.
 * 
 * ============================================================================
 * KEY COMPONENTS
 * ============================================================================
 * 
 * 1. Component Interface (Coffee)
 * - Defines the interface for objects that can be decorated
 * - Methods: getDescription(), getCost()
 * 
 * 2. Concrete Component (SimpleCoffee)
 * - The original object to be decorated
 * - Implements the Component interface
 * - Example: Plain coffee for Rs 50
 * 
 * 3. Decorator (CoffeeDecorator)
 * - Abstract class that implements Component interface
 * - Has a reference to Component object (the thing being decorated)
 * - Provides default behavior that subclasses can override
 * 
 * 4. Concrete Decorators (MilkDecorator, SugarDecorator, ChocolateDecorator)
 * - Extend CoffeeDecorator
 * - Add specific features (cost and description)
 * - Can be stacked/combined together
 * 
 * ============================================================================
 * STRUCTURE
 * ============================================================================
 * 
 * Coffee (Interface)
 * ├── SimpleCoffee (Concrete Component)
 * └── CoffeeDecorator (Abstract Decorator)
 * ├── MilkDecorator (Concrete Decorator)
 * ├── SugarDecorator (Concrete Decorator)
 * └── ChocolateDecorator (Concrete Decorator)
 * 
 * ============================================================================
 * HOW IT WORKS - STEP BY STEP
 * ============================================================================
 * 
 * Step 1: Create base object
 * Coffee coffee = new SimpleCoffee();
 * Result: "Plain Coffee" - Rs 50
 * 
 * Step 2: Wrap with first decorator
 * Coffee withMilk = new MilkDecorator(coffee);
 * Result: "Plain Coffee, Milk" - Rs 70
 * (SimpleCoffee description + ", Milk")
 * (SimpleCoffee cost + 20)
 * 
 * Step 3: Wrap with another decorator
 * Coffee withMilkAndSugar = new SugarDecorator(withMilk);
 * Result: "Plain Coffee, Milk, Sugar" - Rs 75
 * (withMilk description + ", Sugar")
 * (withMilk cost + 5)
 * 
 * Step 4: Can continue wrapping
 * Coffee final = new ChocolateDecorator(withMilkAndSugar);
 * Result: "Plain Coffee, Milk, Sugar, Chocolate" - Rs 105
 * 
 * ============================================================================
 * EXAMPLE: Building Coffee with Decorators
 * ============================================================================
 * 
 * ChocolateDecorator ← wraps ← SugarDecorator ← wraps ← MilkDecorator ← wraps ←
 * SimpleCoffee
 * (adds chocolate) (adds sugar) (adds milk) (base)
 * Rs +30 Rs +5 Rs +20 Rs 50
 * Total: Rs 105
 * 
 * ============================================================================
 * ADVANTAGES
 * ============================================================================
 * 
 * 1. FLEXIBILITY
 * - Add features at runtime, not compile time
 * - Mix and match decorators in any combination
 * 
 * 2. SINGLE RESPONSIBILITY
 * - Each decorator has one job (add one feature)
 * - SimpleCoffee is never modified
 * 
 * 3. OPEN/CLOSED PRINCIPLE
 * - Open for extension: Create new decorators easily
 * - Closed for modification: Don't change existing code
 * 
 * 4. NO CLASS EXPLOSION
 * - Without decorator: Need classes like CoffeeWithMilkAndSugar,
 * CoffeeWithChocolateAndSugar, etc. (many combinations!)
 * - With decorator: Just 3 decorators + 1 component
 * 
 * ============================================================================
 * DISADVANTAGES
 * ============================================================================
 * 
 * 1. Can create deeply nested chains (hard to debug sometimes)
 * 2. More objects in memory (each decorator is an object)
 * 3. Order matters sometimes (though in this case it doesn't)
 * 
 * ============================================================================
 * WHEN TO USE DECORATOR PATTERN
 * ============================================================================
 * 
 * Use Decorator when:
 * - You need to add features to objects dynamically
 * - Too many combinations make subclassing impractical
 * - You want to keep adding responsibilities without modifying original code
 * 
 * Real-world examples:
 * - Coffee shop: Coffee + Milk + Sugar + Chocolate
 * - HTML tags: <b><i><u>Text</u></i></b> (wrapping)
 * - Pizza builder: Base + Cheese + Pepperoni + Mushrooms
 * - UI Components: Button + Border + Scrollbar + Shadow
 * 
 * ============================================================================
 * COMPARISON WITH OTHER PATTERNS
 * ============================================================================
 * 
 * Decorator vs Inheritance:
 * - Inheritance: Creates new class for each combination (CoffeeWithMilk extends
 * Coffee)
 * - Decorator: Wraps objects without creating new classes
 * - Decorator is more flexible!
 * 
 * Decorator vs Strategy:
 * - Decorator: Changes object structure (adds behavior)
 * - Strategy: Changes algorithm used by object
 * 
 * ============================================================================
 */
public class DecoratorPatternExplanation {
    // This is just documentation - no code here
}
