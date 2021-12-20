package models;

import java.util.Objects;

public class UserRole {
private int userroleid;
private String userrole;

public UserRole() {
}

public UserRole(int userroleid, String userrole) {
    this.userroleid = userroleid;
    this.userrole = userrole;
}

    public int getUserroleid() {
        return userroleid;
    }

    public void setUserroleid(int userroleid) {
        this.userroleid = userroleid;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return userroleid == userRole.userroleid && Objects.equals(userrole, userRole.userrole);
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userroleid=" + userroleid +
                ", userrole='" + userrole + '\'' +
                '}';
    }
}
