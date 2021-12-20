package models;

import java.util.Objects;

public class User {
    private int ersusersid;
    private String ersusername;
    private String userfirstname;
    private String userlastname;
    private String useremail;
    private int userroleid;

    public User() {
    }

    public User(int ersusersid, String ersusername, String userfirstname, String userlastname, String useremail, int userroleid) {
        this.ersusersid = ersusersid;
        this.ersusername = ersusername;
        this.userfirstname = userfirstname;
        this.userlastname = userlastname;
        this.useremail = useremail;
        this.userroleid = userroleid;
    }

    public int getErsusersid() {
        return ersusersid;
    }

    public void setErsusersid(int ersusersid) {
        this.ersusersid = ersusersid;
    }

    public String getErsusername() {
        return ersusername;
    }

    public void setErsusername(String ersusername) {
        this.ersusername = ersusername;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public int getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(int userroleid) {
        this.userroleid = userroleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ersusersid == user.ersusersid && userroleid == user.userroleid && Objects.equals(ersusername, user.ersusername) && Objects.equals(userfirstname, user.userfirstname) && Objects.equals(userlastname, user.userlastname) && Objects.equals(useremail, user.useremail);
    }

    @Override
    public String toString() {
        return "User{" +
                "ersusersid=" + ersusersid +
                ", ersusername='" + ersusername + '\'' +
                ", userfirstname='" + userfirstname + '\'' +
                ", userlastname='" + userlastname + '\'' +
                ", useremail='" + useremail + '\'' +
                ", userroleid=" + userroleid +
                '}';
    }
}
