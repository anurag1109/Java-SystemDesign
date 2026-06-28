package lld2.designPattern.creationalDP.objectPoolV1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Object Pool - manages a pool of reusable objects
 */
public class ObjectPool {
    private final List<Poolable> availableObjects = new ArrayList<>();
    private final ConcurrentHashMap<String, Poolable> usedObjects = new ConcurrentHashMap<>();
    private final ObjectFactory factory;
    private final int maxPoolSize;

    public ObjectPool(ObjectFactory factory, int maxPoolSize) {
        this.factory = factory;
        this.maxPoolSize = maxPoolSize;
        initializePool();
    }

    /**
     * Initialize the pool with objects
     */
    private void initializePool() {
        for (int i = 0; i < maxPoolSize; i++) {
            Poolable obj = factory.create(i);
            availableObjects.add(obj);
        }
        System.out.println("Pool initialized with " + maxPoolSize + " objects");
    }

    /**
     * Get an object from the pool
     * @return A poolable object
     */
    public synchronized Poolable borrowObject() {
        if (availableObjects.isEmpty()) {
            System.out.println("WARNING: No available objects in pool!");
            return null;
        }
        Poolable obj = availableObjects.remove(0);
        usedObjects.put(obj.getId(), obj);
        System.out.println("Borrowed: " + obj.getId() + " | Available: " + availableObjects.size() + " | In Use: " + usedObjects.size());
        return obj;
    }

    /**
     * Return an object to the pool
     * @param obj The object to return
     */
    public synchronized void returnObject(Poolable obj) {
        if (obj == null) return;
        usedObjects.remove(obj.getId());
        obj.reset();
        availableObjects.add(obj);
        System.out.println("Returned: " + obj.getId() + " | Available: " + availableObjects.size() + " | In Use: " + usedObjects.size());
    }

    /**
     * Get pool statistics
     */
    public void printStats() {
        System.out.println("\n=== Pool Statistics ===");
        System.out.println("Total Pool Size: " + maxPoolSize);
        System.out.println("Available Objects: " + availableObjects.size());
        System.out.println("Used Objects: " + usedObjects.size());
        System.out.println("=======================\n");
    }

    public int getAvailableCount() {
        return availableObjects.size();
    }

    public int getUsedCount() {
        return usedObjects.size();
    }
}