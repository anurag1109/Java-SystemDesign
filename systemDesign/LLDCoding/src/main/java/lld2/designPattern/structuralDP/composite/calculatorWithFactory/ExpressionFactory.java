package lld2.designPattern.structuralDP.composite.calculatorWithFactory;

/**
 * Factory class using the Factory Design Pattern
 * Provides static methods to create different types of Expression objects
 * 
 * Benefits:
 * 1. Centralized object creation logic
 * 2. Decouples client code from concrete classes
 * 3. Easy to modify how objects are created
 * 4. Easy to add new expression types
 */
public class ExpressionFactory {

    /**
     * Creates a Number expression
     * 
     * @param value the numeric value
     * @return a Number expression
     */
    public static Expression createNumber(double value) {
        return new Number(value);
    }

    /**
     * Creates an Add expression
     * 
     * @param left  the left operand expression
     * @param right the right operand expression
     * @return an Add expression
     */
    public static Expression createAdd(Expression left, Expression right) {
        return new Add(left, right);
    }

    /**
     * Creates a Subtract expression
     * 
     * @param left  the left operand expression
     * @param right the right operand expression
     * @return a Subtract expression
     */
    public static Expression createSubtract(Expression left, Expression right) {
        return new Subtract(left, right);
    }

    /**
     * Creates a Multiply expression
     * 
     * @param left  the left operand expression
     * @param right the right operand expression
     * @return a Multiply expression
     */
    public static Expression createMultiply(Expression left, Expression right) {
        return new Multiply(left, right);
    }

    /**
     * Creates a Divide expression
     * 
     * @param left  the left operand expression
     * @param right the right operand expression
     * @return a Divide expression
     */
    public static Expression createDivide(Expression left, Expression right) {
        return new Divide(left, right);
    }

    /**
     * Enum-based factory method - alternative approach
     * Can be extended with additional operations
     */
    public enum Operation {
        ADD {
            @Override
            public Expression create(Expression left, Expression right) {
                return new Add(left, right);
            }
        },
        SUBTRACT {
            @Override
            public Expression create(Expression left, Expression right) {
                return new Subtract(left, right);
            }
        },
        MULTIPLY {
            @Override
            public Expression create(Expression left, Expression right) {
                return new Multiply(left, right);
            }
        },
        DIVIDE {
            @Override
            public Expression create(Expression left, Expression right) {
                return new Divide(left, right);
            }
        };

        public abstract Expression create(Expression left, Expression right);
    }

    /**
     * Creates expression using enum-based factory
     * 
     * @param operation the operation type (ADD, SUBTRACT, MULTIPLY, DIVIDE)
     * @param left      the left operand
     * @param right     the right operand
     * @return the created expression
     */
    public static Expression createOperation(Operation operation, Expression left, Expression right) {
        return operation.create(left, right);
    }
}
