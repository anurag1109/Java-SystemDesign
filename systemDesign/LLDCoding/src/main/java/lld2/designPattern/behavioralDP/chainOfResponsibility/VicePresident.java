package lld2.designPattern.behavioralDP.chainOfResponsibility;

/**
 * VicePresident - Top level approver in the chain
 * Can approve leave requests up to 30 days
 */
public class VicePresident extends LeaveApprover {
    // VP's authority: can approve up to 30 days (top authority)
    private static final int MAX_DAYS = 30;

    public VicePresident(LeaveApprover nextApprover) {
        super(nextApprover);
    }

    @Override
    protected boolean canApprove(LeaveRequest request) {
        return request.getDays() <= MAX_DAYS;
    }

    @Override
    protected String getApproverName() {
        return "[VICE PRESIDENT]";
    }
}
