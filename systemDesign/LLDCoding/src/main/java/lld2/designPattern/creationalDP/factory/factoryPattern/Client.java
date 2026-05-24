package lld2.designPattern.creationalDP.factory.factoryPattern;

/**
 * Client Class - Demonstrates the Factory Method Pattern
 * 
 * HOW IT WORKS:
 * 1. Client requests a shape using ShapeFactory.createShape()
 * 2. Client doesn't need to know how to create each shape
 * 3. Client just calls draw() and calculateArea() on the returned shape
 * 4. Each shape knows how to draw and calculate its own area
 */
public class Client {

    public static void main(String[] args) {
        System.out.println("========== Factory Method Pattern Demo ==========\n");

        // Create different shapes using the factory
        Shape circle = ShapeFactory.createShape("CIRCLE", 5);
        Shape rectangle = ShapeFactory.createShape("RECTANGLE", 4, 6);
        Shape triangle = ShapeFactory.createShape("TRIANGLE", 3, 4);

        // Draw all shapes
        System.out.println("\n--- Drawing Shapes ---");
        if (circle != null)
            circle.draw();
        if (rectangle != null)
            rectangle.draw();
        if (triangle != null)
            triangle.draw();

        // Calculate and display areas
        System.out.println("\n--- Calculating Areas ---");
        if (circle != null) {
            System.out.println(circle.getShapeName() + " Area: " +
                    String.format("%.2f", circle.calculateArea()));
        }
        if (rectangle != null) {
            System.out.println(rectangle.getShapeName() + " Area: " +
                    String.format("%.2f", rectangle.calculateArea()));
        }
        if (triangle != null) {
            System.out.println(triangle.getShapeName() + " Area: " +
                    String.format("%.2f", triangle.calculateArea()));
        }

        // Demonstrate the benefit of factory pattern
        System.out.println("\n--- Factory Pattern Benefits ---");
        System.out.println("✓ Client doesn't know about Circle, Rectangle, Triangle classes");
        System.out.println("✓ Client only uses Shape interface and ShapeFactory");
        System.out.println("✓ Easy to add new shapes without changing client code");
        System.out.println("✓ All creation logic is centralized in ShapeFactory");

        // Try invalid shape
        System.out.println("\n--- Testing Invalid Shape ---");
        Shape invalid = ShapeFactory.createShape("PENTAGON", 5);

        System.out.println("\n========== End of Demo ==========");
    }
}
