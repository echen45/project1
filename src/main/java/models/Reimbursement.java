package models;

import java.util.Objects;

public class Reimbursement {
    private int reimbid;
    private double reimbamount;
    private String reimbsubmitted;
    private String reimbresolved;
    private String reimbdescription;
    //private long reimbreceipt;
    private int reimbauthor;
    private int reimbresolver;
    private int reimbstatusid;
    private int reimbtypeid;

    public Reimbursement() {
    }

    public Reimbursement(int reimbid, double reimbamount, String reimbsubmitted, String reimbresolved, String reimbdescription, /*long reimbreceipt,*/int reimbauthor, int reimbresolver, int reimbstatusid, int reimbtypeid) {
        this.reimbid = reimbid;
        this.reimbamount = reimbamount;
        this.reimbsubmitted = reimbsubmitted;
        this.reimbresolved = reimbresolved;
        this.reimbdescription = reimbdescription;
        //this.reimbreceipt = reimbreceipt;
        this.reimbauthor = reimbauthor;
        this.reimbresolver = reimbresolver;
        this.reimbstatusid = reimbstatusid;
        this.reimbtypeid = reimbtypeid;
    }

    public int getReimbid() {
        return reimbid;
    }

    public void setReimbid(int reimbid) {
        this.reimbid = reimbid;
    }

    public double getReimbamount() {
        return reimbamount;
    }

    public void setReimbamount(double reimbamount) {
        this.reimbamount = reimbamount;
    }

    public String getReimbsubmitted() {
        return reimbsubmitted;
    }

    public void setReimbsubmitted(String reimbsubmitted) {
        this.reimbsubmitted = reimbsubmitted;
    }

    public String getReimbresolved() {
        return reimbresolved;
    }

    public void setReimbresolved(String reimbresolved) {
        this.reimbresolved = reimbresolved;
    }

    public String getReimbdescription() {
        return reimbdescription;
    }

    public void setReimbdescription(String reimbdescription) {
        this.reimbdescription = reimbdescription;
    }
/*
    public long getReimbreceipt() {
        return reimbreceipt;
    }

    public void setReimbreceipt(long reimbreceipt) {
        this.reimbreceipt = reimbreceipt;
    }*/

    public int getReimbauthor() {
        return reimbauthor;
    }

    public void setReimbauthor(int reimbauthor) {
        this.reimbauthor = reimbauthor;
    }

    public int getReimbresolver() {
        return reimbresolver;
    }

    public void setReimbresolver(int reimbresolver) {
        this.reimbresolver = reimbresolver;
    }

    public int getReimbstatusid() {
        return reimbstatusid;
    }

    public void setReimbstatusid(int reimbstatusid) {
        this.reimbstatusid = reimbstatusid;
    }

    public int getReimbtypeid() {
        return reimbtypeid;
    }

    public void setReimbtypeid(int reimbtypeid) {
        this.reimbtypeid = reimbtypeid;
    }
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return reimbid == that.reimbid && Double.compare(that.reimbamount, reimbamount) == 0 && reimbreceipt == that.reimbreceipt && reimbauthor == that.reimbauthor && reimbresolver == that.reimbresolver && reimbstatusid == that.reimbstatusid && reimbtypeid == that.reimbtypeid && Objects.equals(reimbsubmitted, that.reimbsubmitted) && Objects.equals(reimbresolved, that.reimbresolved) && Objects.equals(reimbdescription, that.reimbdescription);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursement that = (Reimbursement) o;
        return reimbid == that.reimbid && Double.compare(that.reimbamount, reimbamount) == 0 && reimbauthor == that.reimbauthor && reimbresolver == that.reimbresolver && reimbstatusid == that.reimbstatusid && reimbtypeid == that.reimbtypeid && Objects.equals(reimbsubmitted, that.reimbsubmitted) && Objects.equals(reimbresolved, that.reimbresolved) && Objects.equals(reimbdescription, that.reimbdescription);
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbid=" + reimbid +
                ", reimbamount=" + reimbamount +
                ", reimbsubmitted='" + reimbsubmitted + '\'' +
                ", reimbresolved='" + reimbresolved + '\'' +
                ", reimbdescription='" + reimbdescription + '\'' +
                ", reimbreceipt=" + null/*reimbreceipt*/ +
                ", reimbauthor=" + reimbauthor +
                ", reimbresolver=" + reimbresolver +
                ", reimbstatusid=" + reimbstatusid +
                ", reimbtypeid=" + reimbtypeid +
                '}';
    }
}
