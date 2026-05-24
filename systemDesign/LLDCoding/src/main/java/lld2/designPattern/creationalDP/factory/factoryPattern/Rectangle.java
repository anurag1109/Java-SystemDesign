package lld2.designPattern.creationalDP.factory.factoryPattern;

/**
 * Rectangle Class - Implementation of Shape interface
 * Represents a Rectangle shape
 */
public class Rectangle implements Shape {

    private double length;
    private double width;

    /**
     * Constructor to initialize Rectangle with length and width
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Draw the rectangle
     * In a real application, this would draw on a canvas
     */
    @Override
    public void draw() {
        System.out.println("▭ Drawing Rectangle with length: " + length + " and width: " + width);
    }

    /**
     * Calculate the area of rectangle
     * Formula: length * width
     */
    @Override
    public double calculateArea() {
        return length * width;
    }

    /**
     * Get the name of this shape
     */
    @Override
    public String getShapeName() {
        return "Rectangle";
    }
}
