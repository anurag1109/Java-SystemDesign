package lld2.designPattern.structuralDP.composite.calculatorWithFactory;

/**
 * Client demonstrating Composite + Factory Design Patterns
 * 
 * Factory Pattern Benefits:
 * - Abstracts creation logic
 * - Decouples client from concrete classes
 * - Centralized place to modify creation behavior
 * - Easy to add new expression types
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("=== Composite + Factory Design Pattern - Calculator ===\n");

        // Approach 1: Using Static Factory Methods
        System.out.println("--- Approach 1: Using Static Factory Methods ---\n");

        System.out.println("Example 1: Simple Addition (10 + 5)");
        Expression num1 = ExpressionFactory.createNumber(10);
        Expression num2 = ExpressionFactory.createNumber(5);
        Expression addition = ExpressionFactory.createAdd(num1, num2);
        System.out.println("Expression: " + addition);
        System.out.println("Result: " + addition.evaluate());
        System.out.println();

        System.out.println("Example 2: Complex Expression - (10 + 5) * 2");
        Expression complexExpr1 = ExpressionFactory.createMultiply(
                ExpressionFactory.createAdd(
                        ExpressionFactory.createNumber(10),
                        ExpressionFactory.createNumber(5)),
                ExpressionFactory.createNumber(2));
        System.out.println("Expression: " + complexExpr1);
        System.out.println("Result: " + complexExpr1.evaluate());
        System.out.println();

        System.out.println("Example 3: Complex Expression - (20 - 5) / (3 + 2)");
        Expression complexExpr2 = ExpressionFactory.createDivide(
                ExpressionFactory.createSubtract(
                        ExpressionFactory.createNumber(20),
                        ExpressionFactory.createNumber(5)),
                ExpressionFactory.createAdd(
                        ExpressionFactory.createNumber(3),
                        ExpressionFactory.createNumber(2)));
        System.out.println("Expression: " + complexExpr2);
        System.out.println("Result: " + complexExpr2.evaluate());
        System.out.println();

        System.out.println("Example 4: Very Complex - ((10 + 5) * (20 - 5)) / 2");
        Expression complexExpr3 = ExpressionFactory.createDivide(
                ExpressionFactory.createMultiply(
                        ExpressionFactory.createAdd(
                                ExpressionFactory.createNumber(10),
                                ExpressionFactory.createNumber(5)),
                        ExpressionFactory.createSubtract(
                                ExpressionFactory.createNumber(20),
                                ExpressionFactory.createNumber(5))),
                ExpressionFactory.createNumber(2));
        System.out.println("Expression: " + complexExpr3);
        System.out.println("Result: " + complexExpr3.evaluate());
        System.out.println();

        System.out.println("Example 5: Nested Operations - ((5 * 2) + (10 / 2)) * 3");
        Expression complexExpr4 = ExpressionFactory.createMultiply(
                ExpressionFactory.createAdd(
                        ExpressionFactory.createMultiply(
                                ExpressionFactory.createNumber(5),
                                ExpressionFactory.createNumber(2)),
                        ExpressionFactory.createDivide(
                                ExpressionFactory.createNumber(10),
                                ExpressionFactory.createNumber(2))),
                ExpressionFactory.createNumber(3));
        System.out.println("Expression: " + complexExpr4);
        System.out.println("Result: " + complexExpr4.evaluate());
        System.out.println();

        // Approach 2: Using Enum-based Factory
        System.out.println("--- Approach 2: Using Enum-based Factory ---\n");

        System.out.println("Example 6: (15 + 10) using Enum Factory");
        Expression enumAdd = ExpressionFactory.createOperation(
                ExpressionFactory.Operation.ADD,
                ExpressionFactory.createNumber(15),
                ExpressionFactory.createNumber(10));
        System.out.println("Expression: " + enumAdd);
        System.out.println("Result: " + enumAdd.evaluate());
        System.out.println();

        System.out.println("Example 7: (30 - 12) using Enum Factory");
        Expression enumSubtract = ExpressionFactory.createOperation(
                ExpressionFactory.Operation.SUBTRACT,
                ExpressionFactory.createNumber(30),
                ExpressionFactory.createNumber(12));
        System.out.println("Expression: " + enumSubtract);
        System.out.println("Result: " + enumSubtract.evaluate());
        System.out.println();

        System.out.println("Example 8: (8 * 7) using Enum Factory");
        Expression enumMultiply = ExpressionFactory.createOperation(
                ExpressionFactory.Operation.MULTIPLY,
                ExpressionFactory.createNumber(8),
                ExpressionFactory.createNumber(7));
        System.out.println("Expression: " + enumMultiply);
        System.out.println("Result: " + enumMultiply.evaluate());
        System.out.println();

        System.out.println("Example 9: (100 / 5) using Enum Factory");
        Expression enumDivide = ExpressionFactory.createOperation(
                ExpressionFactory.Operation.DIVIDE,
                ExpressionFactory.createNumber(100),
                ExpressionFactory.createNumber(5));
        System.out.println("Expression: " + enumDivide);
        System.out.println("Result: " + enumDivide.evaluate());
        System.out.println();

        // Error Handling
        System.out.println("--- Error Handling: Division by Zero ---\n");
        try {
            Expression errorExpr = ExpressionFactory.createDivide(
                    ExpressionFactory.createNumber(10),
                    ExpressionFactory.createNumber(0));
            System.out.println("Expression: " + errorExpr);
            System.out.println("Result: " + errorExpr.evaluate());
        } catch (ArithmeticException e) {
            System.out.println("Error caught: " + e.getMessage());
        }
    }
}
