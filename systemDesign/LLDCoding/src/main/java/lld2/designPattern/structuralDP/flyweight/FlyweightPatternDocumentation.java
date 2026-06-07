package lld2.designPattern.structuralDP.flyweight;

/**
 * FlyweightPatternDocumentation - Explains the Flyweight Design Pattern
 * 
 * ============================================================================
 * PROBLEM:
 * ============================================================================
 * In a word processor, each character in a large document requires an object.
 * A 100,000 character document would create 100,000 objects!
 * This wastes a lot of memory because many characters are identical.
 * 
 * Example: Word "Hello"
 * Without Flyweight: 5 separate Character objects created
 * With Flyweight: Only 4 unique Character objects (h, e, l, o)
 * 'l' is reused for both occurrences
 * 
 * ============================================================================
 * SOLUTION: Flyweight Pattern
 * ============================================================================
 * Share common data (intrinsic state) between objects to reduce memory usage.
 * 
 * Divide state into:
 * 1. Intrinsic State (Shared) - Character properties (value, font, size, color)
 * 2. Extrinsic State (Unique) - Position (row, column) where character appears
 * 
 * ============================================================================
 * COMPONENTS:
 * ============================================================================
 * 
 * 1. Flyweight (Character)
 * - Shared object with intrinsic state
 * - Properties: value, font, size, color
 * - Same 'A' object used for all 'A' characters
 * 
 * 2. FlyweightFactory (CharacterFactory)
 * - Creates and caches Flyweight objects
 * - Returns existing object if already created
 * - Prevents duplicate object creation
 * 
 * 3. UnsharedConcreteFlyweight (CharacterPosition)
 * - Holds extrinsic state (row, column)
 * - References the shared Flyweight object
 * 
 * 4. Client (WordProcessor)
 * - Uses factory to get character objects
 * - Manages collection of CharacterPosition objects
 * 
 * ============================================================================
 * HOW IT WORKS:
 * ============================================================================
 * 
 * Step 1: Create WordProcessor
 * WordProcessor processor = new WordProcessor("Arial", 12, "Black");
 * 
 * Step 2: Add text "Hello"
 * processor.addText("Hello");
 * 
 * Step 3: Factory processes each character:
 * - 'H': Create new, cache it
 * - 'e': Create new, cache it
 * - 'l': Create new, cache it (first 'l')
 * - 'l': REUSE from cache (second 'l' - same object!)
 * - 'o': Create new, cache it
 * 
 * Result: 4 Character objects created, 5 CharacterPosition objects
 * 
 * ============================================================================
 * BENEFITS:
 * ============================================================================
 * ✓ Massive memory savings for large documents
 * ✓ Reduced object creation and garbage collection
 * ✓ Improved performance
 * ✓ Share common data across many objects
 * ✓ Transparent to client code
 * 
 * Example: 100,000 character document
 * Without Flyweight: 100,000 Character objects
 * With Flyweight: ~100 Character objects (typical alphabet)
 * Memory Saved: 99,900 objects!
 * 
 * ============================================================================
 * DRAWBACKS:
 * ============================================================================
 * ✗ Increased complexity
 * ✗ Need to separate intrinsic and extrinsic state
 * ✗ Thread safety required for shared objects
 * 
 * ============================================================================
 * REAL-WORLD EXAMPLES:
 * ============================================================================
 * - Text Editors: Reuse character objects (Microsoft Word, Google Docs)
 * - Game Development: Share sprite/texture objects
 * - Web Browsers: Cache font/style objects
 * - Database Connection Pools: Reuse connection objects
 * - String Interning: Java strings are flyweights
 * 
 * ============================================================================
 * DIAGRAM:
 * ============================================================================
 * 
 * Client (WordProcessor)
 * |
 * ├── Factory (CharacterFactory) ◄── Cache
 * | |
 * | └── Flyweight Objects
 * | • 'H' at (0,0)
 * | • 'e' at (0,1)
 * | • 'l' at (0,2) ← Same 'l' object
 * | • 'l' at (0,3) ← Reused 'l'
 * | • 'o' at (0,4)
 * |
 * └── CharacterPosition (stores position + reference to Flyweight)
 * 
 * ============================================================================
 * PSEUDO CODE:
 * ============================================================================
 * 
 * class CharacterFactory {
 * cache = {}
 * 
 * getCharacter(char, font, size, color) {
 * key = char + "_" + font + "_" + size + "_" + color
 * if (cache contains key) {
 * return cache[key] // Reuse existing
 * } else {
 * character = new Character(char, font, size, color)
 * cache[key] = character // Store for future use
 * return character
 * }
 * }
 * }
 * 
 * ============================================================================
 */
public class FlyweightPatternDocumentation {
    // This is just a documentation class - refer to implementation for details
}
