package lld2.designPattern.structuralDP.composite.calculator;

/**
 * Composite class for Multiplication operation
 * Combines two expressions and evaluates their product
 */
public class Multiply implements Expression {
    private Expression left;
    private Expression right;

    public Multiply(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }
}
