
/**
 * ========================================================================
 * TEMPLATE METHOD DESIGN PATTERN - COMPREHENSIVE DOCUMENTATION
 * ========================================================================
 *
 * 1. WHAT IS THE TEMPLATE METHOD PATTERN?
 * ----------------------------------------
 * The Template Method is a behavioral design pattern that:
 * - Defines the skeleton of an algorithm in a base class
 * - Lets subclasses override specific steps without changing the algorithm's
 * structure
 * - Enforces a consistent flow while allowing customization
 *
 * Real-world analogy: A recipe for making a sandwich
 * - The template: "Take bread → Add filling → Close → Serve"
 * - Customization: Different fillings (egg, chicken, veggie) for different
 * sandwich types
 * - The overall process remains the same
 *
 *
 * 2. KEY COMPONENTS
 * -----------------
 *
 * a) Abstract Template Class (DataProcessor in our example):
 * - Contains the template method (processData) that defines the algorithm
 * skeleton
 * - Template method is declared as "final" to prevent subclasses from
 * overriding it
 * - Contains concrete methods (readData, parseData, saveData) that implement
 * common steps
 * - Contains abstract methods (transformData) that subclasses must implement
 *
 * Example:
 * public final void processData(String data) {
 * String raw = readData(data);
 * String parsed = parseData(raw);
 * String processed = transformData(parsed);
 * saveData(processed);
 * }
 *
 * b) Concrete Subclasses (CSVDataProcessor, JSONDataProcessor,
 * XMLDataProcessor):
 * - Implement the abstract methods to define their specific behavior
 * - Follow the algorithm structure defined by the template method
 * - Each provides its own implementation of transformData()
 *
 *
 * 3. FLOW OF EXECUTION
 * ---------------------
 *
 * When client calls: processor.processData("sample data")
 *
 * Step-by-step execution:
 * 1. readData() → parses input data (COMMON STEP)
 * 2. parseData() → trims and validates (COMMON STEP)
 * 3. transformData() → varies by subclass (CUSTOMIZABLE STEP)
 * 4. saveData() → outputs result (COMMON STEP)
 *
 * For CSVDataProcessor.transformData():
 * → Returns data.toUpperCase()
 *
 * For JSONDataProcessor.transformData():
 * → Returns JSON formatted data
 *
 * For XMLDataProcessor.transformData():
 * → Returns XML wrapped data
 *
 *
 * 4. ADVANTAGES
 * ---------------
 * ✓ Code Reuse: Common steps are written once in the base class
 * ✓ Consistency: All subclasses follow the same algorithm structure
 * ✓ Flexibility: Subclasses can customize specific steps
 * ✓ Maintainability: Changes to common logic only in one place
 * ✓ Predictable Order: Algorithm structure is guaranteed
 *
 *
 * 5. DISADVANTAGES
 * -------------------
 * ✗ Limited Flexibility: Fixed algorithm structure
 * ✗ Subclass Explosion: Many subclasses for each variation
 * ✗ Complexity: Requires understanding base class structure
 *
 *
 * 6. WHEN TO USE
 * -----------------
 * ✓ Multiple classes with similar algorithms but minor differences
 * ✓ Want to avoid code duplication
 * ✓ Want to enforce a specific order of operations
 * ✓ Examples:
 * - Data processors (CSV, JSON, XML)
 * - Report generators (PDF, HTML, Excel)
 * - Game character creation
 * - Authentication flows
 *
 *
 * 7. COMPARISON WITH OTHER PATTERNS
 * ------------------------------------
 * 
 * vs Strategy:
 * - Template Method: Inheritance, fixed structure
 * - Strategy: Composition, swappable algorithms
 *
 * vs Factory:
 * - Template Method: Defines HOW to execute
 * - Factory: Defines HOW to create objects
 *
 * vs Decorator:
 * - Template Method: Defines algorithm skeleton
 * - Decorator: Adds behavior dynamically
 *
 *
 * 8. EXAMPLE WALKTHROUGH
 * -------------------------
 *
 * DataProcessor (Abstract Base)
 * ├── CSVDataProcessor (transforms to uppercase)
 * ├── JSONDataProcessor (formats as JSON)
 * └── XMLDataProcessor (wraps in XML)
 *
 * When calling: new CSVDataProcessor().processData("hello")
 * 1. readData("hello") → "hello" (common)
 * 2. parseData("hello") → "hello" (common)
 * 3. transformData("hello") → "HELLO" (CSV-specific)
 * 4. saveData("HELLO") → prints result (common)
 *
 */
