package lld1.collections;

/**
 * MyHashMap - Custom HashMap Implementation
 * 
 * A simplified HashMap that demonstrates:
 * - Hash function using hashCode()
 * - Bucket array for storing entries
 * - Collision handling using chaining (linked list)
 * - Dynamic resizing with power-of-2 table sizes
 * 
 * Key Components:
 * 1. Entry class: Represents key-value pair with next pointer for chaining
 * 2. Bucket array: Fixed-size array where entries are stored
 * 3. Hash function: Maps hashCode to bucket index
 * 4. Chaining: Linked list for handling hash collisions
 */
public class MyHashMap<K, V> {

    // ============ CAPACITY CONSTANTS ============

    /**
     * INITIAL_SIZE = 1 << 4 = 16
     * 1 << 4 means shift 1 left by 4 bits = 2^4 = 16
     * HashMap always uses power of 2 for faster modulo operation
     * Instead of: index = hashCode % size (slow division)
     * We use: index = hashCode & (size - 1) (fast bitwise AND)
     */
    private static final int INITIAL_SIZE = 1 << 4; // 16

    /**
     * MAXIMUM_CAPACITY = 1 << 30 = 1,073,741,824 (1 billion+)
     * Maximum allowed capacity to prevent overflow
     * 1 << 30 = 2^30
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * LOAD_FACTOR = 0.75
     * When size reaches 75% of capacity, table is resized
     * This balances between space and time complexity
     * Example: If capacity = 16, resize when size > 12
     */
    private static final float LOAD_FACTOR = 0.75f;

    // ============ INSTANCE VARIABLES ============

    /** Bucket array - each bucket can hold multiple entries (chaining) */
    private Entry<K, V>[] hashTable;

    /** Current number of key-value pairs stored */
    private int size;

    // ============ CONSTRUCTORS ============

    /**
     * Default constructor - creates HashMap with initial capacity of 16
     */
    public MyHashMap() {
        this(INITIAL_SIZE);
    }

    /**
     * Constructor with custom capacity
     * 
     * @param capacity desired initial capacity
     */
    @SuppressWarnings("unchecked")
    public MyHashMap(int capacity) {
        // Calculate appropriate table size (must be power of 2)
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
        size = 0;
    }

    // ============ KEY ALGORITHM: TABLE SIZE CALCULATION ============

    /**
     * tableSizeFor - Calculates smallest power of 2 >= capacity
     * 
     * This uses bit manipulation to fill all lower bits with 1s,
     * then add 1 to get next power of 2.
     * 
     * Example: cap = 10
     * Step 1: n = 10 - 1 = 9 (binary: 0000 1001)
     * Step 2: n |= n >>> 1 (binary: 0000 1101) = 13
     * Step 3: n |= n >>> 2 (binary: 0000 1111) = 15
     * Step 4: n |= n >>> 4 (binary: 0000 1111) = 15
     * Step 5: n |= n >>> 8 (binary: 0000 1111) = 15
     * Step 6: n |= n >>> 16 (binary: 0000 1111) = 15
     * Result: 15 (which is 2^4 - 1), then return 15 + 1 = 16 (2^4)
     * 
     * This ensures index calculation using (hashCode & (size - 1)) works correctly
     * 
     * @param cap desired capacity
     * @return smallest power of 2 >= cap
     */
    private int tableSizeFor(int cap) {
        // Start with cap - 1 to handle case when cap is already power of 2
        int n = cap - 1;

        // These operations spread the highest set bit to all lower positions
        // Each step fills twice as many bits as before
        n |= n >>> 1; // Fill 2 bits
        n |= n >>> 2; // Fill 4 bits
        n |= n >>> 4; // Fill 8 bits
        n |= n >>> 8; // Fill 16 bits
        n |= n >>> 16; // Fill 32 bits

        // Return n+1 if valid, otherwise return MAXIMUM_CAPACITY
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    // ============ PUT OPERATION ============

    /**
     * put - Inserts or updates a key-value pair
     * 
     * Process:
     * 1. Calculate hash code of key
     * 2. Find bucket index using (hashCode & (capacity - 1))
     * 3. Check if bucket is empty or has collisions (traverse chain)
     * 4. If key exists, update value; otherwise add new entry
     * 5. Check load factor and resize if needed
     * 
     * @param key   the key to insert
     * @param value the value to associate with key
     */
    public void put(K key, V value) {
        if (key == null) {
            return; // Skip null keys
        }

        // Step 1: Calculate hash code and find bucket index
        int hashCode = key.hashCode() & hashTable.length;
        Entry<K, V> node = hashTable[hashCode];

        // Step 2: Traverse the chain to find or create entry
        if (node == null) {
            // Bucket is empty - create new entry
            Entry<K, V> newNode = new Entry<>(key, value);
            hashTable[hashCode] = newNode;
            size++;
        } else {
            // Bucket has entries - traverse the chain
            Entry<K, V> previousNode = node;
            while (node != null) {
                if (node.key.equals(key)) {
                    // Key already exists - update value
                    node.value = value;
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            // Key not found - add new entry at end of chain
            Entry<K, V> newNode = new Entry<>(key, value);
            previousNode.next = newNode;
            size++;
        }

        // Step 3: Check if resizing needed (load factor = 0.75)
        if (size >= hashTable.length * LOAD_FACTOR) {
            resize();
        }
    }

    // ============ GET OPERATION ============

    /**
     * get - Retrieves value associated with key
     * 
     * Process:
     * 1. Calculate hash code to find bucket
     * 2. Traverse chain in bucket to find matching key
     * 3. Return value if found, null otherwise
     * 
     * Time Complexity:
     * - Best case: O(1) - no collision
     * - Worst case: O(n) - all keys hash to same bucket
     * - Average case: O(1) - good hash function with proper load factor
     * 
     * @param key the key to search for
     * @return the value associated with key, or null if not found
     */
    public V get(K key) {
        if (key == null) {
            return null;
        }

        // Find bucket using hash code
        int hashCode = key.hashCode() & hashTable.length;
        Entry<K, V> node = hashTable[hashCode];

        // Traverse chain to find matching key
        while (node != null) {
            if (node.key.equals(key)) {
                return node.value;
            }
            node = node.next;
        }

        return null; // Key not found
    }

    // ============ REMOVE OPERATION ============

    /**
     * remove - Removes key-value pair from map
     * 
     * Process:
     * 1. Calculate hash code to find bucket
     * 2. Traverse chain to find matching key
     * 3. Remove entry by updating pointers
     * 4. Decrement size
     * 
     * @param key the key to remove
     * @return the value associated with removed key, or null if not found
     */
    public V remove(K key) {
        if (key == null) {
            return null;
        }

        // Find bucket using hash code
        int hashCode = key.hashCode() & hashTable.length;
        Entry<K, V> node = hashTable[hashCode];

        // Handle empty bucket
        if (node == null) {
            return null;
        }

        // Check if first node matches
        if (node.key.equals(key)) {
            hashTable[hashCode] = node.next;
            size--;
            return node.value;
        }

        // Traverse chain to find matching key
        Entry<K, V> previousNode = node;
        node = node.next;
        while (node != null) {
            if (node.key.equals(key)) {
                previousNode.next = node.next;
                size--;
                return node.value;
            }
            previousNode = node;
            node = node.next;
        }

        return null; // Key not found
    }

    // ============ UTILITY METHODS ============

    /**
     * size - Returns number of key-value pairs in map
     * 
     * @return current size
     */
    public int size() {
        return size;
    }

    /**
     * isEmpty - Checks if map is empty
     * 
     * @return true if map contains no entries
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * containsKey - Checks if key exists in map
     * 
     * @param key the key to search for
     * @return true if key is in map
     */
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // ============ INTERNAL RESIZE OPERATION ============

    /**
     * resize - Doubles capacity and rehashes all entries
     * 
     * Process:
     * 1. Create new larger bucket array (double the size)
     * 2. Rehash all existing entries into new array
     * (Old bucket indices won't work with new size)
     * 3. Replace old hashTable with new one
     * 
     * Time Complexity: O(n) where n = number of entries
     * This is expensive but happens infrequently due to load factor
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        Entry<K, V>[] oldHashTable = hashTable;

        // Create new table with double capacity
        hashTable = new Entry[oldHashTable.length * 2];
        size = 0;

        // Rehash all entries from old table
        for (Entry<K, V> entry : oldHashTable) {
            while (entry != null) {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }

    // ============ ENTRY CLASS (Inner Class) ============

    /**
     * Entry - Represents a single key-value pair in the map
     * 
     * Features:
     * - Generic type parameters for key and value
     * - 'next' pointer for handling collisions (chaining)
     * - Used as node in linked list within each bucket
     */
    static class Entry<K, V> {
        K key; // The key
        V value; // The value
        Entry<K, V> next; // Pointer to next entry (for collision chaining)

        /**
         * Entry constructor
         * 
         * @param key   the key
         * @param value the value
         */
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (Entry<K, V> entry : hashTable) {
            while (entry != null) {
                sb.append(entry.toString()).append(", ");
                entry = entry.next;
            }
        }

        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("}");
        return sb.toString();
    }
}
