package models;

import java.util.Objects;

public class ReimbursementStatus {
    private int reimbstatusid;
    private String reimbstatus;

    public ReimbursementStatus() {
    }

    public ReimbursementStatus(int reimbstatusid, String reimbstatus) {
        this.reimbstatusid = reimbstatusid;
        this.reimbstatus = reimbstatus;
    }

    public int getReimbstatusid() {
        return reimbstatusid;
    }

    public void setReimbstatusid(int reimbstatusid) {
        this.reimbstatusid = reimbstatusid;
    }

    public String getReimbstatus() {
        return reimbstatus;
    }

    public void setReimbstatus(String reimbstatus) {
        this.reimbstatus = reimbstatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementStatus that = (ReimbursementStatus) o;
        return reimbstatusid == that.reimbstatusid && Objects.equals(reimbstatus, that.reimbstatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbstatusid, reimbstatus);
    }

    @Override
    public String toString() {
        return "ReimbursementStatus{" +
                "reimbstatusid=" + reimbstatusid +
                ", reimbstatus='" + reimbstatus + '\'' +
                '}';
    }
}
