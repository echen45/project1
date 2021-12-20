package dao;

import models.Reimbursement;
import models.User;
import org.apache.log4j.Logger;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    String url;
    String username;
    String password;

    Logger logger = Logger.getLogger(UserDaoImpl.class);

    public UserDaoImpl() {
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/Reimbursement";
        this.username = System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public UserDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public void createUser(User user) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO ERS_USERS VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getErsusersid());
            ps.setString(2, user.getErsusername());
            ps.setString(3, user.getUserfirstname());
            ps.setString(4, user.getUserlastname());
            ps.setString(5, user.getUseremail());
            ps.setInt(6, user.getUserroleid());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    @Override
    public void deleteUser(User info) {
        try (Connection conn = DriverManager.getConnection(url, username, password)) { //try with resources
            String sql = "DELETE FROM ERS_USERS WHERE ERS_USERS_ID = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, info.getErsusersid());
            ps.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    public boolean compareData(User info) {
         //User userInfo=null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) { //try with resources
            String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, info.getErsusername());
            ps.executeQuery();
            //userInfo = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
        } catch (SQLException e) {
            logger.error(e);
            return false;
        }
        return true;
    }

    public int user(User info) {
        User userInfo=null;
        System.out.println("green");
        try (Connection conn = DriverManager.getConnection(url, username, password)) { //try with resources
            String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, info.getErsusername());
            ResultSet rs=ps.executeQuery();
            System.out.println("green2");
            if(rs.next())
                userInfo = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            System.out.println("green3");
            int userId = userInfo.getErsusersid();
            System.out.println(userId);
            return userId;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return -1;
    }

    public int userId(User info) {
        User userInfo=null;
        try (Connection conn = DriverManager.getConnection(url, username, password)) { //try with resources
            String sql = "SELECT * FROM ERS_USERS WHERE ERS_USERNAME = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, info.getErsusername());
            ResultSet rs=ps.executeQuery();
            if(rs.next())
                userInfo = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            int typeId = userInfo.getUserroleid();
            System.out.println("blue");
            return typeId;
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e);
        }
        return -1;
    }
}



