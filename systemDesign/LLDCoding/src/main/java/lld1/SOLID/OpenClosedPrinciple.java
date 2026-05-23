package lld1.SOLID;

import java.util.ArrayList;
import java.util.List;

/**
 * OPEN/CLOSED PRINCIPLE (OCP)
 * 
 * Definition: A class should be open for extension but closed for modification.
 * 
 * Key Points:
 * 1. You should be able to add new functionality without modifying existing code
 * 2. Use abstraction (interfaces/abstract classes) to define contracts
 * 3. Implement new features through inheritance or composition
 * 4. Avoid making changes to existing tested and working code
 * 
 * Benefits:
 * - Reduces risk of breaking existing functionality
 * - Makes code more stable and reliable
 * - Easier to add new features
 * - Better for team collaboration
 * - Reduces regression issues
 */

// ============================================================================
// BAD EXAMPLE: Violating Open/Closed Principle
// ============================================================================

/**
 * This shape calculator violates OCP because:
 * 1. To add a new shape, you must modify the existing method
 * 2. The calculateArea method is closed for extension
 * 3. Each new shape type requires modifying the existing code
 * 
 * This is risky because you might break existing functionality.
 */
class AreaCalculatorBad {
    // This method needs modification every time a new shape is added
    public double calculateArea(Object[] shapes) {
        double area = 0;

        for (Object shape : shapes) {
            // Using instanceof and casting - not flexible
            if (shape instanceof CircleBad) {
                CircleBad circle = (CircleBad) shape;
                area += Math.PI * circle.radius * circle.radius;
            } else if (shape instanceof RectangleBad) {
                RectangleBad rectangle = (RectangleBad) shape;
                area += rectangle.width * rectangle.height;
            }
            // To add TriangleBad, we need to modify this method!
            else if (shape instanceof TriangleBad) {
                TriangleBad triangle = (TriangleBad) shape;
                area += 0.5 * triangle.base * triangle.height;
            }
        }
        return area;
    }
}

class CircleBad {
    public double radius;

    public CircleBad(double radius) {
        this.radius = radius;
    }
}

class RectangleBad {
    public double width;
    public double height;

    public RectangleBad(double width, double height) {
        this.width = width;
        this.height = height;
    }
}

class TriangleBad {
    public double base;
    public double height;

    public TriangleBad(double base, double height) {
        this.base = base;
        this.height = height;
    }
}

// ============================================================================
// GOOD EXAMPLE: Following Open/Closed Principle
// ============================================================================

/**
 * Shape interface: Defines the contract for all shapes
 * This allows the code to be OPEN for extension without modification
 */
interface Shape {
    /**
     * Calculate the area of the shape
     * 
     * @return the area value
     */
    double calculateArea();

    /**
     * Get the name of the shape
     * 
     * @return the shape name
     */
    String getShapeName();
}

/**
 * Circle class: Concrete implementation of Shape
 * Can be added without modifying existing code
 */
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        // Area formula for circle: π * r²
        return Math.PI * radius * radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }
}

/**
 * Rectangle class: Concrete implementation of Shape
 * Can be added without modifying existing code
 */
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        // Area formula for rectangle: length × width
        return width * height;
    }

    @Override
    public String getShapeName() {
        return "Rectangle";
    }
}

/**
 * Triangle class: Concrete implementation of Shape
 * Can be added without modifying existing code
 */
class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        // Area formula for triangle: (base × height) / 2
        return 0.5 * base * height;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }
}

/**
 * Ellipse class: A NEW shape we can add without modifying existing code
 * This demonstrates the "Open for extension" part of OCP
 */
class Ellipse implements Shape {
    private double majorAxis;
    private double minorAxis;

    public Ellipse(double majorAxis, double minorAxis) {
        this.majorAxis = majorAxis;
        this.minorAxis = minorAxis;
    }

    @Override
    public double calculateArea() {
        // Area formula for ellipse: π * a * b
        return Math.PI * majorAxis * minorAxis;
    }

    @Override
    public String getShapeName() {
        return "Ellipse";
    }
}

/**
 * Pentagon class: Another NEW shape we can add without modifying existing code
 */
class Pentagon implements Shape {
    private double side;

    public Pentagon(double side) {
        this.side = side;
    }

    @Override
    public double calculateArea() {
        // Area formula for regular pentagon: (√5 * side²) / 4 * (1 + √5/2)
        return (Math.sqrt(5) * side * side) / 4 * (1 + Math.sqrt(5) / 2);
    }

    @Override
    public String getShapeName() {
        return "Pentagon";
    }
}

/**
 * AreaCalculator: Closed for modification, Open for extension
 * 
 * This class does NOT need to be modified when new shapes are added
 * It works with ANY class that implements the Shape interface
 */
class AreaCalculator {
    private List<Shape> shapes;

    public AreaCalculator() {
        this.shapes = new ArrayList<>();
    }

    /**
     * Add a shape to the calculator
     * Works with any Shape implementation
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Calculate total area of all shapes
     * This method NEVER changes, regardless of how many shape types exist
     */
    public double calculateTotalArea() {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }

    /**
     * Get area breakdown by shape type
     */
    public void printAreaDetails() {
        System.out.println("\n--- Area Details ---");
        for (Shape shape : shapes) {
            System.out.printf("%s: %.2f square units\n",
                    shape.getShapeName(),
                    shape.calculateArea());
        }
    }

    /**
     * Get number of shapes
     */
    public int getShapeCount() {
        return shapes.size();
    }

    /**
     * Clear all shapes
     */
    public void clearShapes() {
        shapes.clear();
    }
}

/**
 * ShapeAnalyzer: Another class that benefits from OCP
 * Can analyze any shape without modification
 */
class ShapeAnalyzer {
    /**
     * Analyze shapes and return the largest one
     */
    public Shape findLargestShape(List<Shape> shapes) {
        Shape largest = shapes.get(0);
        for (Shape shape : shapes) {
            if (shape.calculateArea() > largest.calculateArea()) {
                largest = shape;
            }
        }
        return largest;
    }

    /**
     * Analyze shapes and return average area
     */
    public double calculateAverageArea(List<Shape> shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea / shapes.size();
    }

    /**
     * Sort shapes by area (using bubble sort for simplicity)
     */
    public List<Shape> sortShapesByArea(List<Shape> shapes) {
        List<Shape> sorted = new ArrayList<>(shapes);
        int n = sorted.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted.get(j).calculateArea() > sorted.get(j + 1).calculateArea()) {
                    // Swap
                    Shape temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }
}

// ============================================================================
// CLIENT: Demonstrating Open/Closed Principle
// ============================================================================

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        System.out.println("=== Open/Closed Principle (OCP) ===\n");

        // Create calculator
        AreaCalculator calculator = new AreaCalculator();

        // Add existing shapes
        System.out.println("--- Adding Existing Shapes ---");
        calculator.addShape(new Circle(5));
        System.out.println("Added Circle with radius 5");

        calculator.addShape(new Rectangle(4, 6));
        System.out.println("Added Rectangle with width 4 and height 6");

        calculator.addShape(new Triangle(10, 8));
        System.out.println("Added Triangle with base 10 and height 8");

        // Add NEW shapes WITHOUT modifying AreaCalculator
        System.out.println("\n--- Adding NEW Shapes (Without Modification) ---");
        calculator.addShape(new Ellipse(7, 5));
        System.out.println("Added Ellipse with major axis 7 and minor axis 5");

        calculator.addShape(new Pentagon(6));
        System.out.println("Added Pentagon with side 6");

        // Calculate total area
        System.out.println("\n--- Total Area Calculation ---");
        calculator.printAreaDetails();
        System.out.printf("\nTotal Area: %.2f square units\n", calculator.calculateTotalArea());

        // Use ShapeAnalyzer
        System.out.println("\n--- Shape Analysis ---");
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(3));
        shapes.add(new Rectangle(5, 5));
        shapes.add(new Triangle(6, 4));
        shapes.add(new Ellipse(8, 4));

        ShapeAnalyzer analyzer = new ShapeAnalyzer();

        Shape largest = analyzer.findLargestShape(shapes);
        System.out.printf("Largest shape: %s with area %.2f\n",
                largest.getShapeName(),
                largest.calculateArea());

        double average = analyzer.calculateAverageArea(shapes);
        System.out.printf("Average area: %.2f\n", average);

        List<Shape> sorted = analyzer.sortShapesByArea(shapes);
        System.out.println("\nShapes sorted by area:");
        for (Shape shape : sorted) {
            System.out.printf("  %s: %.2f\n", shape.getShapeName(), shape.calculateArea());
        }

        System.out.println("\n=== Conclusion ===");
        System.out.println("By following OCP:");
        System.out.println("1. New shapes can be added without modifying existing code");
        System.out.println("2. AreaCalculator is CLOSED for modification");
        System.out.println("3. AreaCalculator is OPEN for extension (works with new shapes)");
        System.out.println("4. Existing code remains stable and tested");
        System.out.println("5. Reduces risk of introducing bugs");
    }
}
