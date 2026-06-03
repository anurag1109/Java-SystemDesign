package lld2.designPattern.behavioralDP.chainOfResponsibility;

/**
 * Director - Second level approver in the chain
 * Can approve leave requests up to 10 days
 */
public class Director extends LeaveApprover {
    // Director's authority: can approve up to 10 days
    private static final int MAX_DAYS = 10;

    public Director(LeaveApprover nextApprover) {
        super(nextApprover);
    }

    @Override
    protected boolean canApprove(LeaveRequest request) {
        return request.getDays() <= MAX_DAYS;
    }

    @Override
    protected String getApproverName() {
        return "[DIRECTOR]";
    }
}
