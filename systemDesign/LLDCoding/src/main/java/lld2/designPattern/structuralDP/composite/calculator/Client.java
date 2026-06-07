package lld2.designPattern.structuralDP.composite.calculator;

/**
 * Client class demonstrating the Composite Design Pattern with Calculator
 *
 * The Composite Pattern allows us to:
 * 1. Treat individual objects (Number) and compositions (Operations) uniformly
 * 2. Build complex expressions by composing simpler ones
 * 3. Evaluate complex mathematical expressions recursively
 *
 * Example: (10 + 5) * (20 - 5) / 2
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== Composite Design Pattern - Simple Calculator ===\n");

        // Example 1: Simple addition (10 + 5)
        System.out.println("Example 1: Simple Addition");
        Expression num1 = new Number(10);
        Expression num2 = new Number(5);
        Expression addition = new Add(num1, num2);
        System.out.println("Expression: " + addition);
        System.out.println("Result: " + addition.evaluate());
        System.out.println();

        // Example 2: Simple multiplication (3 * 4)
        System.out.println("Example 2: Simple Multiplication");
        Expression num3 = new Number(3);
        Expression num4 = new Number(4);
        Expression multiplication = new Multiply(num3, num4);
        System.out.println("Expression: " + multiplication);
        System.out.println("Result: " + multiplication.evaluate());
        System.out.println();

        // Example 3: Complex expression (10 + 5) * 2
        System.out.println("Example 3: Complex Expression - (10 + 5) * 2");
        Expression complexExpr1 = new Multiply(new Add(new Number(10), new Number(5)), new Number(2));
        System.out.println("Expression: " + complexExpr1);
        System.out.println("Result: " + complexExpr1.evaluate());
        System.out.println();

        // Example 4: Complex expression (20 - 5) / (3 + 2)
        System.out.println("Example 4: Complex Expression - (20 - 5) / (3 + 2)");
        Expression complexExpr2 = new Divide(
                new Subtract(new Number(20), new Number(5)),
                new Add(new Number(3), new Number(2)));
        System.out.println("Expression: " + complexExpr2);
        System.out.println("Result: " + complexExpr2.evaluate());
        System.out.println();

        // Example 5: Very complex expression ((10 + 5) * (20 - 5)) / 2
        System.out.println("Example 5: Very Complex Expression - ((10 + 5) * (20 - 5)) / 2");
        Expression complexExpr3 = new Divide(
                new Multiply(
                        new Add(new Number(10), new Number(5)),
                        new Subtract(new Number(20), new Number(5))),
                new Number(2));
        System.out.println("Expression: " + complexExpr3);
        System.out.println("Result: " + complexExpr3.evaluate());
        System.out.println();

        // Example 6: Demonstrating recursive composition
        System.out.println("Example 6: Nested Operations - ((5 * 2) + (10 / 2)) * 3");
        Expression complexExpr4 = new Multiply(
                new Add(
                        new Multiply(new Number(5), new Number(2)),
                        new Divide(new Number(10), new Number(2))),
                new Number(3));
        System.out.println("Expression: " + complexExpr4);
        System.out.println("Result: " + complexExpr4.evaluate());
        System.out.println();

        // Example 7: Division by zero handling
        System.out.println("Example 7: Error Handling - Division by Zero");
        try {
            Expression errorExpr = new Divide(new Number(10), new Number(0));
            System.out.println("Expression: " + errorExpr);
            System.out.println("Result: " + errorExpr.evaluate());
        } catch (ArithmeticException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
    }
}
