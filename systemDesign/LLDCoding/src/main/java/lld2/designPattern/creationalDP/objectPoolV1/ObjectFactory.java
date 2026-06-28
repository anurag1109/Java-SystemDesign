package lld2.designPattern.creationalDP.objectPoolV1;

/**
 * Factory interface for creating poolable objects
 */
public interface ObjectFactory {
    Poolable create(int index);
}