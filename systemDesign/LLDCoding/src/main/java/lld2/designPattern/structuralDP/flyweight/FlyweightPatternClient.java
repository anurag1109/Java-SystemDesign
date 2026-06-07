package lld2.designPattern.structuralDP.flyweight;

/**
 * FlyweightPatternClient - Demonstrates Word Processor using Flyweight Pattern
 * 
 * Flyweight Pattern Benefits:
 * 1. Reduces memory usage by sharing character objects
 * 2. Same character 'e' is reused multiple times
 * 3. Example: "Hello" - 5 characters, but only 4 unique objects
 */
public class FlyweightPatternClient {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║  FLYWEIGHT DESIGN PATTERN - WORD PROCESSOR             ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");

        // Create word processor with specific font settings
        WordProcessor processor = new WordProcessor("Arial", 12, "Black");

        // Add text to document
        System.out.println("\n--- Adding text: 'Hello' ---");
        processor.addText("Hello");

        // Print memory statistics
        processor.printStatistics();

        // Add more text to demonstrate reuse
        System.out.println("\n--- Adding text: ' World' ---");
        processor.addText(" World");

        // Print updated statistics
        processor.printStatistics();

        // Add text with repeated characters
        System.out.println("\n--- Adding text: ' Mississippi' ---");
        processor.addText(" Mississippi");

        // Final statistics
        processor.printStatistics();

        // Show how many objects were NOT created due to Flyweight pattern
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║  KEY BENEFITS OF FLYWEIGHT PATTERN:                    ║");
        System.out.println("╠════════════════════════════════════════════════════════╣");
        System.out.println("║ ✓ Character objects are reused                         ║");
        System.out.println("║ ✓ 'l' in Hello is same object as 'l' in Mississippi    ║");
        System.out.println("║ ✓ Significant memory savings with large documents      ║");
        System.out.println("║ ✓ Improves performance by reducing garbage collection  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
