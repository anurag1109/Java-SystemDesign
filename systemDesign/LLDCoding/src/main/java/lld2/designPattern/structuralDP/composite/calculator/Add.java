package lld2.designPattern.structuralDP.composite.calculator;

/**
 * Composite class for Addition operation
 * Combines two expressions and evaluates their sum
 */
public class Add implements Expression {
    private Expression left;
    private Expression right;

    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}
