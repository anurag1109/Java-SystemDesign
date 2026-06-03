package lld2.designPattern.structuralDP.proxy;

/**
 * Subject Interface - Document
 * 
 * This interface defines the contract that both RealDocument and ProxyDocument
 * must follow
 * It allows us to use either the real object or proxy object in the same way
 */
public interface Document {

    /**
     * Display the document content
     * This method will be implemented differently in RealDocument and ProxyDocument
     */
    void display();

    /**
     * Get document information
     */
    String getInfo();
}
