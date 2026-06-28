package lld2.designPattern.behavioralDP.templateMethod;

/**
 * Client demonstrating Template Method Pattern
 * 
 * Template Method Pattern:
 * - Defines the skeleton of an algorithm in the base class
 * - Lets subclasses override specific steps without changing algorithm
 * structure
 * - The template method (processData) is final - cannot be overridden
 * - Only specific steps are overridden in subclasses
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("=== Template Method Design Pattern ===\n");

        String inputData = "  hello world  ";

        // Process with CSV Processor
        System.out.println("--- CSV Processing ---");
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.processData(inputData);
        System.out.println();

        // Process with JSON Processor
        System.out.println("--- JSON Processing ---");
        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.processData(inputData);
        System.out.println();

        // Process with XML Processor
        System.out.println("--- XML Processing ---");
        DataProcessor xmlProcessor = new XMLDataProcessor();
        xmlProcessor.processData(inputData);
        System.out.println();

        System.out.println("=== Key Points ===");
        System.out.println("1. All processors follow the same algorithm structure");
        System.out.println("2. Only the 'transformData' step differs between implementations");
        System.out.println("3. The template method (processData) is final - cannot be overridden");
        System.out.println("4. Common steps (read, parse, save) are in the base class");
    }
}
