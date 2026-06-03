package lld2.designPattern.behavioralDP.chainOfResponsibility;

/**
 * LeaveApprover - Abstract base class for all leave approvers
 * Implements the Chain of Responsibility pattern
 * 
 * Each handler:
 * 1. Checks if they can handle the request
 * 2. If yes, processes it
 * 3. If no, passes it to the next handler in the chain
 */
public abstract class LeaveApprover {
    // Reference to the next approver in the chain
    protected LeaveApprover nextApprover;

    public LeaveApprover(LeaveApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    /**
     * Approves the leave request
     * Each subclass will implement based on their authority
     */
    public final void approveLeave(LeaveRequest request) {
        // Check if current handler can handle
        if (canApprove(request)) {
            System.out.println("✓ " + getApproverName() + " APPROVED leave for " +
                    request.getEmployeeName() + " for " + request.getDays() + " days");
            System.out.println("  Reason: " + request.getReason());
        } else if (nextApprover != null) {
            // Pass to next handler in chain
            System.out.println("↓ " + getApproverName() + " cannot approve, forwarding to next level...");
            nextApprover.approveLeave(request);
        } else {
            // No one can approve
            System.out.println("✗ REJECTED - No authority to approve this leave request");
        }
    }

    /**
     * Abstract method - each handler decides their approval limit
     */
    protected abstract boolean canApprove(LeaveRequest request);

    /**
     * Abstract method - returns the name of this approver
     */
    protected abstract String getApproverName();
}
