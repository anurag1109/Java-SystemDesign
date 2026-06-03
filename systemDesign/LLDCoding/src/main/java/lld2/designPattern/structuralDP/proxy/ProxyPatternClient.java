package lld2.designPattern.structuralDP.proxy;

/**
 * ProxyPatternClient - Demonstrates Proxy Design Pattern
 * 
 * The Proxy pattern provides a placeholder/surrogate for another object
 * to control access to it. This is useful for:
 * 1. Lazy Loading: Load expensive objects only when needed
 * 2. Access Control: Check permissions before accessing
 * 3. Logging: Log all access to objects
 * 4. Caching: Cache results of expensive operations
 */
public class ProxyPatternClient {

    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("     PROXY DESIGN PATTERN - DOCUMENT ACCESS CONTROL");
        System.out.println("═══════════════════════════════════════════════════════════");

        // Scenario 1: Admin User accessing document
        System.out.println("\n\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ SCENARIO 1: ADMIN USER ACCESSING DOCUMENT                   ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        // Create proxy for admin (proxy is created instantly, no loading yet!)
        System.out.println("\n1️⃣ Creating ProxyDocument for ADMIN user...");
        Document adminProxy = new ProxyDocument("secret-report.pdf", "ADMIN");

        System.out.println("\n2️⃣ Getting document info (lightweight operation)...");
        String adminInfo = adminProxy.getInfo();
        System.out.println("Result: " + adminInfo);

        System.out.println("\n3️⃣ Displaying document (heavy operation - triggers loading)...");
        adminProxy.display();

        // Scenario 2: Regular User accessing document
        System.out.println("\n\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ SCENARIO 2: REGULAR USER ACCESSING DOCUMENT                ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.println("\n1️⃣ Creating ProxyDocument for USER...");
        Document userProxy = new ProxyDocument("data-file.xlsx", "USER");

        System.out.println("\n2️⃣ Getting document info...");
        String userInfo = userProxy.getInfo();
        System.out.println("Result: " + userInfo);

        System.out.println("\n3️⃣ Attempting to display document...");
        userProxy.display();

        // Scenario 3: Guest trying to access document
        System.out.println("\n\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ SCENARIO 3: GUEST USER TRYING TO ACCESS DOCUMENT           ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.println("\n1️⃣ Creating ProxyDocument for GUEST...");
        Document guestProxy = new ProxyDocument("public-info.txt", "GUEST");

        System.out.println("\n2️⃣ Attempting to display document...");
        guestProxy.display();

        // Scenario 4: Demonstrating Lazy Loading
        System.out.println("\n\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ SCENARIO 4: LAZY LOADING DEMONSTRATION                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");

        System.out.println("\n1️⃣ Creating 3 proxy documents (instant - no loading)...");
        Document proxy1 = new ProxyDocument("document1.pdf", "ADMIN");
        Document proxy2 = new ProxyDocument("document2.pdf", "ADMIN");
        Document proxy3 = new ProxyDocument("document3.pdf", "ADMIN");
        System.out.println("✓ All 3 proxies created instantly!");

        System.out.println("\n2️⃣ Only accessing document2 (lazy loading in action)...");
        System.out.println("Notice: document1 and document3 are NEVER loaded!");
        proxy2.display();

        // Summary
        printSummary();
    }

    private static void printSummary() {
        System.out.println("\n\n═══════════════════════════════════════════════════════════");
        System.out.println("                    PROXY PATTERN BENEFITS");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("\n✓ LAZY LOADING:");
        System.out.println("  - Document loaded only when display() is called");
        System.out.println("  - getInfo() doesn't trigger loading");

        System.out.println("\n✓ ACCESS CONTROL:");
        System.out.println("  - Permission check before allowing access");
        System.out.println("  - Prevents unauthorized access");

        System.out.println("\n✓ PERFORMANCE:");
        System.out.println("  - Avoid loading expensive objects unnecessarily");
        System.out.println("  - Real object only created when needed");

        System.out.println("\n✓ TRANSPARENCY:");
        System.out.println("  - Client uses Document interface");
        System.out.println("  - Client doesn't know if it's Real or Proxy");

        System.out.println("\n═══════════════════════════════════════════════════════════\n");
    }
}
