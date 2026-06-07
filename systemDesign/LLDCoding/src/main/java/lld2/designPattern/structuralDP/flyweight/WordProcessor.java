package lld2.designPattern.structuralDP.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * WordProcessor - Uses Flyweight pattern to manage characters
 * 
 * Benefits:
 * - Memory efficient: Same character object is reused
 * - Example: Word "hello" = h, e, l, l, o
 * Only 4 unique characters stored (h, e, l, o)
 * 'l' is reused for both occurrences
 */
public class WordProcessor {
    private List<CharacterPosition> characters = new ArrayList<>();
    private String font;
    private int size;
    private String color;

    public WordProcessor(String font, int size, String color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    /**
     * Add text to the document
     * Uses CharacterFactory to get/reuse character objects
     */
    public void addText(String text) {
        int row = characters.size() / 80; // Simple row calculation (80 chars per line)
        int column = characters.size() % 80;

        for (char c : text.toCharArray()) {
            // Get character from factory (reused if exists, created if new)
            Character character = CharacterFactory.getCharacter(c, font, size, color);

            // Create position object with extrinsic state
            CharacterPosition charPos = new CharacterPosition(character, row, column);
            characters.add(charPos);

            column++;
            if (column >= 80) {
                column = 0;
                row++;
            }
        }
    }

    /**
     * Display all characters
     */
    public void display() {
        System.out.println("\n=== Document Display ===");
        for (CharacterPosition charPos : characters) {
            charPos.display();
        }
    }

    /**
     * Get character count
     */
    public int getCharacterCount() {
        return characters.size();
    }

    /**
     * Get unique character count (from factory cache)
     */
    public int getUniqueCharacterCount() {
        return CharacterFactory.getCacheSize();
    }

    /**
     * Print memory statistics
     */
    public void printStatistics() {
        System.out.println("\n=== Memory Statistics ===");
        System.out.println("Total characters in document: " + getCharacterCount());
        System.out.println("Unique characters (cached): " + getUniqueCharacterCount());
        System.out
                .println("Memory saved: " + (getCharacterCount() - getUniqueCharacterCount()) + " objects not created");
        CharacterFactory.printCacheStatistics();
    }
}
