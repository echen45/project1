package dao;

import models.User;
import models.UserRole;

import java.util.List;

public interface UserDao {
    //List<UserRole> getAllUserRoles();
    //UserRole getUserRole(Integer userroleid);
    void createUser(User user);
    //void updateUserRole(Integer userroleid);
    void deleteUser(User user);
    boolean compareData(User info);
    int user(User info);
    int userId(User info);

}
