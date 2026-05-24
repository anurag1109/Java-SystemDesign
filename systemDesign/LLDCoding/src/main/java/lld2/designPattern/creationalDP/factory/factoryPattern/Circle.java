package lld2.designPattern.creationalDP.factory.factoryPattern;

/**
 * Circle Class - Implementation of Shape interface
 * Represents a Circle shape
 */
public class Circle implements Shape {

    private double radius;

    /**
     * Constructor to initialize Circle with radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Draw the circle
     * In a real application, this would draw on a canvas
     */
    @Override
    public void draw() {
        System.out.println("🔵 Drawing Circle with radius: " + radius);
    }

    /**
     * Calculate the area of circle
     * Formula: π * r²
     */
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Get the name of this shape
     */
    @Override
    public String getShapeName() {
        return "Circle";
    }
}
