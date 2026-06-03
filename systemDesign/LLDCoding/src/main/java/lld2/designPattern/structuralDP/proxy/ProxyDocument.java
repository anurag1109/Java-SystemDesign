package lld2.designPattern.structuralDP.proxy;

/**
 * ProxyDocument - Proxy Subject
 * 
 * The proxy controls access to the RealDocument
 * Benefits:
 * 1. Lazy Loading: Only load the real document when actually needed
 * 2. Access Control: Check permissions before allowing access
 * 3. Logging: Log all access to the document
 * 4. Performance: Avoid loading unless necessary
 */
public class ProxyDocument implements Document {

    private String fileName;
    private RealDocument realDocument; // Lazy loaded - initially null
    private String userRole;

    public ProxyDocument(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
        // Note: RealDocument is NOT created here - Lazy Loading!
        this.realDocument = null;
    }

    /**
     * Lazy loading pattern: Only create RealDocument when actually needed
     */
    private RealDocument getRealDocument() {
        if (realDocument == null) {
            System.out.println("🔐 [PROXY] First access detected, loading real document now...");
            realDocument = new RealDocument(fileName);
        }
        return realDocument;
    }

    /**
     * Check if user has permission to access document
     */
    private boolean hasPermission() {
        // Simple permission check based on user role
        if ("ADMIN".equals(userRole) || "USER".equals(userRole)) {
            System.out.println("✓ [PROXY] Permission granted for user role: " + userRole);
            return true;
        }
        System.out.println("✗ [PROXY] Permission denied for user role: " + userRole);
        return false;
    }

    @Override
    public void display() {
        System.out.println("\n--- Proxy Display Request ---");

        // Step 1: Check permission
        if (!hasPermission()) {
            System.out.println("❌ Cannot display document - Permission denied!");
            return;
        }

        // Step 2: Log the access
        System.out.println("📝 [PROXY] Logging access to document: " + fileName);

        // Step 3: Load real document if needed (Lazy Loading)
        System.out.println("📂 [PROXY] Retrieving real document...");

        // Step 4: Delegate to real document
        getRealDocument().display();
    }

    @Override
    public String getInfo() {
        System.out.println("\n--- Proxy Info Request ---");

        // For info request, we don't need to load the full document
        System.out.println("📝 [PROXY] Getting info without loading full document");

        return "ProxyDocument: " + fileName + " (User: " + userRole + ")";
    }
}
