package lld2.designPattern.creationalDP.factory.factoryPattern;

/**
 * ShapeFactory - Factory Class
 * 
 * This class is responsible for creating different shapes based on the type
 * 
 * BENEFITS:
 * 1. Centralized creation logic - all shape creation happens in one place
 * 2. Easy to add new shapes - just add a new condition
 * 3. Loose coupling - client doesn't need to know about concrete classes
 * 4. Single Responsibility - factory handles creation, shapes handle drawing
 */
public class ShapeFactory {

    /**
     * Factory Method that creates and returns the appropriate shape
     * 
     * @param shapeType - Type of shape to create ("CIRCLE", "RECTANGLE",
     *                  "TRIANGLE")
     * @param params    - Variable number of parameters needed for the shape
     * @return Shape - The created shape object
     */
    public static Shape createShape(String shapeType, double... params) {

        // Check shape type and create the appropriate shape
        if (shapeType == null) {
            return null;
        }

        switch (shapeType.toUpperCase()) {

            case "CIRCLE":
                // Circle needs 1 parameter: radius
                if (params.length >= 1) {
                    return new Circle(params[0]);
                }
                break;

            case "RECTANGLE":
                // Rectangle needs 2 parameters: length and width
                if (params.length >= 2) {
                    return new Rectangle(params[0], params[1]);
                }
                break;

            case "TRIANGLE":
                // Triangle needs 2 parameters: base and height
                if (params.length >= 2) {
                    return new Triangle(params[0], params[1]);
                }
                break;

            default:
                System.out.println("❌ Unknown shape type: " + shapeType);
                return null;
        }

        return null;
    }
}
