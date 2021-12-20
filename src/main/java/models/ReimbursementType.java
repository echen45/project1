package models;

import java.util.Objects;

public class ReimbursementType {
    private int reimbtypeid;
    private String reimbtype;

    public ReimbursementType() {
    }

    public ReimbursementType(int reimbtypeid, String reimbtype) {
        this.reimbtypeid = reimbtypeid;
        this.reimbtype = reimbtype;
    }

    public int getReimbtypeid() {
        return reimbtypeid;
    }

    public void setReimbtypeid(int reimbtypeid) {
        this.reimbtypeid = reimbtypeid;
    }

    public String getReimbtype() {
        return reimbtype;
    }

    public void setReimbtype(String reimbtype) {
        this.reimbtype = reimbtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementType that = (ReimbursementType) o;
        return reimbtypeid == that.reimbtypeid && Objects.equals(reimbtype, that.reimbtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reimbtypeid, reimbtype);
    }

    @Override
    public String toString() {
        return "ReimbursementType{" +
                "reimbtypeid=" + reimbtypeid +
                ", reimbtype='" + reimbtype + '\'' +
                '}';
    }
}
