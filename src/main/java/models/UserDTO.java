package models;

public class UserDTO {
    String ersusername;
    //String role;

    public UserDTO() {
    }

    public UserDTO(String username) {
        this.ersusername = username;
        //this.role = role;
    }

    public String getErsusername() {return ersusername;}

    public void setErsusername(String ersusername) {this.ersusername = ersusername;}

    //public String getRole() {return role;}

    //public void setRole(String role) {this.role = role;}

    @Override
    public String toString() {
        return "UserDTO{" +
                "ersusername='" + ersusername + '\'' +
                '}';
    }
}
