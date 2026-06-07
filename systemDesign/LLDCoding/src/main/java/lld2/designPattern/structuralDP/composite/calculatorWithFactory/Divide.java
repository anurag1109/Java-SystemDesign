package lld2.designPattern.structuralDP.composite.calculatorWithFactory;

/**
 * Composite class for Division operation
 */
public class Divide implements Expression {
    private Expression left;
    private Expression right;

    public Divide(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        double rightValue = right.evaluate();
        if (rightValue == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return left.evaluate() / rightValue;
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }
}
