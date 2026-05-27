package lld1.collections;

/**
 * HashMapClient - Demonstrates MyHashMap usage
 * 
 * Shows all operations:
 * - put: insert/update
 * - get: retrieve value
 * - remove: delete entry
 * - Collision handling
 * - Resizing on load factor
 */
public class HashMapClient {
    public static void main(String[] args) {
        System.out.println("========== CUSTOM HASHMAP DEMONSTRATION ==========\n");

        // Create a custom HashMap
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // ============ PUT OPERATIONS ============
        System.out.println("--- PUT OPERATIONS ---");
        System.out.println("Inserting key-value pairs:");
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Diana", 28);
        map.put("Eve", 32);

        System.out.println("Map after putting 5 entries: " + map);
        System.out.println("Map size: " + map.size() + "\n");

        // ============ GET OPERATIONS ============
        System.out.println("--- GET OPERATIONS ---");
        System.out.println("Getting values:");
        System.out.println("  Alice's age: " + map.get("Alice"));
        System.out.println("  Bob's age: " + map.get("Bob"));
        System.out.println("  Eve's age: " + map.get("Eve"));
        System.out.println("  Unknown person: " + map.get("Frank") + " (null means not found)\n");

        // ============ UPDATE OPERATION ============
        System.out.println("--- UPDATE OPERATION ---");
        System.out.println("Updating Alice's age from 25 to 26:");
        map.put("Alice", 26);
        System.out.println("  Alice's new age: " + map.get("Alice"));
        System.out.println("  Map size: " + map.size() + " (size doesn't change on update)\n");

        // ============ CONTAINSKEY OPERATION ============
        System.out.println("--- CONTAINSKEY OPERATION ---");
        System.out.println("  Contains 'Charlie'? " + map.containsKey("Charlie"));
        System.out.println("  Contains 'George'? " + map.containsKey("George") + "\n");

        // ============ REMOVE OPERATIONS ============
        System.out.println("--- REMOVE OPERATIONS ---");
        System.out.println("Removing 'Bob':");
        Integer removedValue = map.remove("Bob");
        System.out.println("  Removed value: " + removedValue);
        System.out.println("  Map after removal: " + map);
        System.out.println("  Map size: " + map.size());
        System.out.println("  Contains 'Bob' now? " + map.containsKey("Bob") + "\n");

        // ============ REMOVE NON-EXISTENT KEY ============
        System.out.println("--- REMOVE NON-EXISTENT KEY ---");
        System.out.println("Trying to remove 'Frank' (doesn't exist):");
        Integer notFoundValue = map.remove("Frank");
        System.out.println("  Removed value: " + notFoundValue + " (null = not found)\n");

        // ============ MORE INSERTIONS TO TEST RESIZING ============
        System.out.println("--- TESTING RESIZING ---");
        System.out.println("Adding more entries to trigger resizing:");
        map.put("Frank", 40);
        map.put("Grace", 29);
        map.put("Henry", 35);
        map.put("Ivy", 27);
        map.put("Jack", 33);

        System.out.println("  After adding 5 more entries:");
        System.out.println("  Map size: " + map.size());
        System.out.println("  Map: " + map + "\n");

        // ============ FINAL STATE ============
        System.out.println("--- FINAL STATE ---");
        System.out.println("Total entries in map: " + map.size());
        System.out.println("Is empty? " + map.isEmpty());
        System.out.println("Final map: " + map + "\n");

        // ============ COLLISION DEMONSTRATION ============
        System.out.println("--- COLLISION HANDLING DEMONSTRATION ---");
        System.out.println("HashMap uses chaining to handle collisions");
        System.out.println("When two keys hash to same bucket, they form a linked list");
        System.out.println("Example: If 'Alice' and 'Eve' hash to same index:");
        System.out.println("  Bucket[i] -> Alice=26 -> Eve=32 -> null\n");

        System.out.println("========== DEMO COMPLETE ==========");
    }
}
