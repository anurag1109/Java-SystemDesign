package lld2.designPattern.behavioralDP.chainOfResponsibility;

/**
 * ChainOfResponsibilityClient - Demonstrates the Chain of Responsibility
 * Pattern
 * 
 * The request flows through a chain of handlers until someone can handle it
 */
public class ChainOfResponsibilityClient {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("CHAIN OF RESPONSIBILITY PATTERN DEMO");
        System.out.println("========================================\n");

        // Create the chain of approvers (from top to bottom)
        // Manager → Director → VP
        LeaveApprover vp = new VicePresident(null); // Top level, no next
        LeaveApprover director = new Director(vp); // Middle level
        LeaveApprover manager = new Manager(director); // First level

        // Test cases
        System.out.println("--- REQUEST 1: 2 days leave ---");
        LeaveRequest request1 = new LeaveRequest("Raj Kumar", 2, "Personal work");
        manager.approveLeave(request1);
        System.out.println();

        System.out.println("--- REQUEST 2: 7 days leave ---");
        LeaveRequest request2 = new LeaveRequest("Priya Singh", 7, "Vacation");
        manager.approveLeave(request2);
        System.out.println();

        System.out.println("--- REQUEST 3: 15 days leave ---");
        LeaveRequest request3 = new LeaveRequest("Amit Patel", 15, "Extended vacation");
        manager.approveLeave(request3);
        System.out.println();

        System.out.println("--- REQUEST 4: 35 days leave (exceeds all limits) ---");
        LeaveRequest request4 = new LeaveRequest("Sneha Sharma", 35, "Sabbatical");
        manager.approveLeave(request4);
        System.out.println();

        System.out.println("========================================");
        System.out.println("FLOW EXPLANATION:");
        System.out.println("========================================");
        System.out.println("• Manager can approve: 1-3 days");
        System.out.println("• Director can approve: 4-10 days");
        System.out.println("• Vice President can approve: 11-30 days");
        System.out.println("• Beyond 30 days: REJECTED");
        System.out.println("\nEach request flows through the chain");
        System.out.println("until someone can handle it!");
    }
}
