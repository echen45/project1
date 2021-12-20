package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ReimbursementTypeDaoImpl implements ReimbursementTypeDao {
    String url;
    String username;
    String password;

    Logger logger = Logger.getLogger(ReimbursementTypeDaoImpl.class);

    public ReimbursementTypeDaoImpl(){
        this.url = "jdbc:postgresql://" + System.getenv("AWS_RDS_ENDPOINT") + "/reimbursement";
        this.username =  System.getenv("RDS_USERNAME");
        this.password = System.getenv("RDS_PASSWORD");
    }

    public ReimbursementTypeDaoImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    @Override
    public void createReimbursementType() {
        try(Connection conn = DriverManager.getConnection(url, username, password)){
            String sql = "INSERT INTO ers_reimbursement_type VALUES (0, 'LODGING');";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException e){
            logger.error(e);
        }
    }
}
