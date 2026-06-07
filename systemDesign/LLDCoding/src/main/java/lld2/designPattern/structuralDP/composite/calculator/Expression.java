package lld2.designPattern.structuralDP.composite.calculator;

/**
 * Component Interface for the Composite Pattern
 * Defines the contract for both leaf (Number) and composite (Operations)
 * elements
 */
public interface Expression {
    /**
     * Evaluates the expression and returns the result
     * 
     * @return the numeric result of the expression
     */
    double evaluate();
}
