package lld2.designPattern.structuralDP.composite.calculatorWithFactory;

/**
 * Composite class for Subtraction operation
 */
public class Subtract implements Expression {
    private Expression left;
    private Expression right;

    public Subtract(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() - right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " - " + right + ")";
    }
}
