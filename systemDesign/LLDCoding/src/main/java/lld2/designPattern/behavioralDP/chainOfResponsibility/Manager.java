package lld2.designPattern.behavioralDP.chainOfResponsibility;

/**
 * Manager - First level approver in the chain
 * Can approve leave requests up to 3 days
 */
public class Manager extends LeaveApprover {
    // Manager's authority: can approve up to 3 days
    private static final int MAX_DAYS = 3;

    public Manager(LeaveApprover nextApprover) {
        super(nextApprover);
    }

    @Override
    protected boolean canApprove(LeaveRequest request) {
        return request.getDays() <= MAX_DAYS;
    }

    @Override
    protected String getApproverName() {
        return "[MANAGER]";
    }
}
