package lld2.designPattern.structuralDP.proxy;

/**
 * RealDocument - Real Subject
 * 
 * This is the actual resource-heavy object that requires expensive operations
 * In real world: Loading large files from disk, database queries, network
 * calls, etc.
 * 
 * The proxy will control access to this object and optimize when it's actually
 * created/used
 */
public class RealDocument implements Document {

    private String fileName;
    private String content;

    public RealDocument(String fileName) {
        this.fileName = fileName;
        // Simulate expensive operation (loading document from disk/database)
        loadFromDisk();
    }

    /**
     * Simulate expensive operation - loading document
     * This would normally load a large file or query database
     */
    private void loadFromDisk() {
        try {
            // Simulate slow loading operation
            System.out.println("⏳ [REAL DOCUMENT] Loading heavy document: " + fileName + " from disk...");
            Thread.sleep(2000); // Simulate 2 second loading time
            this.content = "This is the content of " + fileName;
            System.out.println("✓ [REAL DOCUMENT] Document loaded successfully!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display() {
        System.out.println("📄 [REAL DOCUMENT] Displaying: " + fileName);
        System.out.println("Content: " + content);
    }

    @Override
    public String getInfo() {
        return "RealDocument: " + fileName + " (Size: ~5MB)";
    }
}
