package lld2.designPattern.creationalDP.factory.factoryPattern;

/**
 * Shape Interface - Contract for all shapes
 * This interface defines what all shapes must be able to do
 */
public interface Shape {

    /**
     * Draw method that all shapes must implement
     * Each shape will draw itself in its own way
     */
    void draw();

    /**
     * Calculate area of the shape
     */
    double calculateArea();

    /**
     * Get the name of the shape
     */
    String getShapeName();
}
