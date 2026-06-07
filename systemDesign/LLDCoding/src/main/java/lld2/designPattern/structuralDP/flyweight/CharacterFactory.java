package lld2.designPattern.structuralDP.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * CharacterFactory - Factory for creating and caching Character objects
 * 
 * This implements the Flyweight pattern by:
 * 1. Creating Character objects on demand
 * 2. Storing them in a cache (HashMap)
 * 3. Reusing the same object instead of creating duplicates
 * 
 * Example: If "Hello" is typed, 'H' and 'l' and 'o' are created once and reused
 */
public class CharacterFactory {
    // Cache to store already created characters
    private static final Map<String, Character> characterCache = new HashMap<>();

    /**
     * Get or create a character
     * If character already exists in cache, return it
     * Otherwise, create new and store in cache
     */
    public static Character getCharacter(char value, String font, int size, String color) {
        // Create a unique key for the character
        String key = value + "_" + font + "_" + size + "_" + color;

        // Check if character already exists in cache
        if (characterCache.containsKey(key)) {
            System.out.println("✓ Reusing character from cache: '" + value + "'");
            return characterCache.get(key);
        }

        // If not in cache, create new character
        System.out.println("+ Creating new character: '" + value + "'");
        Character character = new Character(value, font, size, color);
        characterCache.put(key, character);
        return character;
    }

    /**
     * Get current cache size - shows how many unique characters are stored
     */
    public static int getCacheSize() {
        return characterCache.size();
    }

    /**
     * Print cache statistics
     */
    public static void printCacheStatistics() {
        System.out.println("\n=== Cache Statistics ===");
        System.out.println("Total unique characters in cache: " + characterCache.size());
        System.out.println("Cached characters: " + characterCache.keySet());
    }
}
