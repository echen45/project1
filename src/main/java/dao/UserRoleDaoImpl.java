package dao;

import models.UserRole;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDaoImpl implements UserRoleDao {
    String url;
    String username;
    String password;

    Logger logger = Logger.getLogger(UserRoleDaoImpl.class);

    public UserRoleDaoImpl() {
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/reimbursement";
        this.username =  System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public UserRoleDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*enum Role {
        EMPLOYEE,
        MANAGER
    }

    @Override
    public List<UserRole> getAllUserRoles() {
        List<UserRole> userroles = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM ERS_USER_ROLES;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                userroles.add(new UserRole(rs.getInt(1),rs.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //logger.error(e);
        }
        return userroles;
    }

    @Override
    public UserRole getUserRole(Integer userroleid) {
        return null;
    }*/

    @Override
    public void createUserRole() {
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "INSERT INTO ERS_USER_ROLES VALUES (0, 'employee');";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.error(e);
        }
    }
/*
    @Override
    public void updateUserRole(Integer userroleid) {

    }

    @Override
    public void deleteUserRole(Integer userroleid) {

    }*/
}
