package lld2.designPattern.behavioralDP.chainOfResponsibility;

/**
 * LeaveRequest - Represents a leave request from an employee
 * Contains information about who is requesting leave and for how many days
 */
public class LeaveRequest {
    private String employeeName;
    private int days;
    private String reason;

    public LeaveRequest(String employeeName, int days, String reason) {
        this.employeeName = employeeName;
        this.days = days;
        this.reason = reason;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getDays() {
        return days;
    }

    public String getReason() {
        return reason;
    }
}
