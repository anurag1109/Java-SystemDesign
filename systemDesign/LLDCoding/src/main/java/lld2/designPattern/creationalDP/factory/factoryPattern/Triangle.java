package lld2.designPattern.creationalDP.factory.factoryPattern;

/**
 * Triangle Class - Implementation of Shape interface
 * Represents a Triangle shape
 */
public class Triangle implements Shape {

    private double base;
    private double height;

    /**
     * Constructor to initialize Triangle with base and height
     */
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * Draw the triangle
     * In a real application, this would draw on a canvas
     */
    @Override
    public void draw() {
        System.out.println("△ Drawing Triangle with base: " + base + " and height: " + height);
    }

    /**
     * Calculate the area of triangle
     * Formula: (base * height) / 2
     */
    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }

    /**
     * Get the name of this shape
     */
    @Override
    public String getShapeName() {
        return "Triangle";
    }
}
