package lld2.designPattern.structuralDP.composite.calculatorWithFactory;

/**
 * Component Interface for the Composite Pattern
 * Defines the contract for all expression types
 */
public interface Expression {
    /**
     * Evaluates the expression and returns the result
     * 
     * @return the numeric result of the expression
     */
    double evaluate();
}
