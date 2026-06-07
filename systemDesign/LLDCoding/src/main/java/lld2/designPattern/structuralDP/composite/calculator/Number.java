package lld2.designPattern.structuralDP.composite.calculator;

/**
 * Leaf class in the Composite Pattern
 * Represents a simple numeric value
 */
public class Number implements Expression {
    private double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
