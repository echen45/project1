package dao;

import models.Reimbursement;
import org.apache.log4j.Logger;

import io.javalin.http.Context;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementDaoImpl implements ReimbursementDao {
    String url;
    String username;
    String password;

    Logger logger = Logger.getLogger(ReimbursementDaoImpl.class);

    public ReimbursementDaoImpl(){
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/Reimbursement";
        this.username =  System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public ReimbursementDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Reimbursement> getAllReimbursements(Context context) {
        List<Reimbursement> reimb = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){
        if(context.queryParam("value") == null){
            String sql = "SELECT * FROM ers_reimbursement;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }}
        else if(context.queryParam("value").toString().equals("pending")){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_STATUS_ID = 0;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }}
        else if(context.queryParam("value").equals("approved")){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_STATUS_ID = 1;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }}
        else if(context.queryParam("value").equals("denied")){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_STATUS_ID = 2;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }}/*
            else if(context.queryParam("value").equals("history")){
                String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_AUTHOR = ? AND REIMB_STATUS_ID != 0;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, reimb2.getReimbauthor());
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
                }}
            else if(context.queryParam("value").equals("employeepending")){
                String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_AUTHOR = ? AND REIMB_STATUS_ID = 0;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, reimb2.getReimbauthor());
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
                }}
            else if(context.queryParam("value").equals("one")){
                String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_ID = ?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,reimb2.getReimbid());
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
                }}*/
        } catch (SQLException e) {
            logger.error(e);
        }
        return reimb;
    }

    @Override
    public List<Reimbursement> employeeReimbs(Integer authid, Context context) {
        List<Reimbursement> reimb2 = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            if(context.queryParam("value") == null){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_AUTHOR = ? AND REIMB_STATUS_ID != 0;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, authid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb2.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }}
            else if(context.queryParam("value").equals("employeepending")){
                String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_AUTHOR = ? AND REIMB_STATUS_ID = 0;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, authid);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    reimb2.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
                }}
            else if(context.queryParam("value").equals("one")){
                String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_ID = ?;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,authid);
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    reimb2.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
                    }}
        } catch (SQLException e) {
            logger.error(e);
        }
        return reimb2;
    }

    @Override
    public void createReimbursement(Reimbursement reimb) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "INSERT INTO ers_reimbursement VALUES (default, ?, current_timestamp, null, ?, null, ?, null, default, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            System.out.println("green");
            ps.setDouble(1, reimb.getReimbamount());
            ps.setString(2, reimb.getReimbdescription());
            System.out.println("green2");
            ps.setInt(3, reimb.getReimbauthor());
            //ps.setInt(4, reimb.getReimbresolver());
            System.out.println("green3");
            ps.setInt(4, reimb.getReimbtypeid());
            System.out.println("green4");
            ps.executeUpdate();
            System.out.println("green5");
        }catch (SQLException e){
            logger.error(e);
        }
    }

    @Override
    public void approveDeny(Reimbursement reimb) {
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "UPDATE ers_reimbursement SET REIMB_STATUS_ID = ?, REIMB_RESOLVED = current_timestamp WHERE reimb_id = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, reimb.getReimbtypeid());
            ps.setInt(2, reimb.getReimbid());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            logger.error(e);
        }
    }
/*
    @Override
    public Reimbursement getReimbursement(Integer reimbid) {
        Reimbursement reimb = null;
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_ID = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,reimbid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                reimb = new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
            }
        }catch (SQLException e){
            logger.error(e);
        }
        return reimb;
    }
/*
    @Override
    public List<Reimbursement> emppending(Integer authid) {
        List<Reimbursement> reimb = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_AUTHOR = ? AND REIMB_STATUS_ID = 0;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, authid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return reimb;
    }

    @Override
    public List<Reimbursement> pending() {
        List<Reimbursement> reimb = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_STATUS_ID = 0;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return reimb;
    }

    @Override
    public List<Reimbursement> approved() {
        List<Reimbursement> reimb = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_STATUS_ID = 1;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return reimb;
    }

    @Override
    public List<Reimbursement> denied() {
        List<Reimbursement> reimb = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "SELECT * FROM ers_reimbursement WHERE REIMB_STATUS_ID = 2;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                reimb.add(new Reimbursement(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getTimestamp(4).toString(), rs.getString(5), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (SQLException e) {
            logger.error(e);
        }
        return reimb;
    }
 */
}
