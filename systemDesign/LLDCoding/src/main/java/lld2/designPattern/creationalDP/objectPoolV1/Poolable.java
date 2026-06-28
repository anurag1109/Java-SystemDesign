package lld2.designPattern.creationalDP.objectPoolV1;

/**
 * Poolable interface - Objects that can be pooled must implement this
 */
public interface Poolable {
    /**
     * Reset the object to its initial state for reuse
     */
    void reset();

    /**
     * Get the unique ID of the poolable object
     */
    String getId();
}