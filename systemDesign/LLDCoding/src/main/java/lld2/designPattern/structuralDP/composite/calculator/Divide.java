package lld2.designPattern.structuralDP.composite.calculator;

/**
 * Composite class for Division operation
 * Combines two expressions and evaluates their quotient
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
