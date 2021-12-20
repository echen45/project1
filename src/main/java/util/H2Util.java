package util;

import models.Reimbursement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class H2Util {
    public static String url = "jdbc:h2:./h2/db";
    public static String username = "sa";
    public static String password = "sa";

    public static void createTable(){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            //Reimbursement reimb = new Reimbursement(1, "c1");
            String sql = "CREATE TABLE ERS_REIMBURSEMENT_STATUS(\n" +
                    "REIMB_STATUS_ID int PRIMARY KEY,\n" +
                    "REIMB_STATUS varchar(10) NOT NULL\n" +
                    ")\n" +
                    "\n" +
                    "CREATE TABLE ERS_REIMBURSEMENT_TYPE(\n" +
                    "REIMB_TYPE_ID int PRIMARY KEY,\n" +
                    "REIMB_TYPE varchar(10) NOT null\n" +
                    ")\n" +
                    "\n" +
                    "CREATE TABLE ERS_USER_ROLES(\n" +
                    "ERS_USER_ROLE_ID int PRIMARY KEY,\n" +
                    "USER_ROLE varchar(10) NOT null\n" +
                    ")\n" +
                    "CREATE TABLE ERS_USERS(\n" +
                    "ERS_USERS_ID int PRIMARY KEY,\n" +
                    "ERS_USERNAME varchar(50) Unique,\n" +
                    "USER_FIRST_NAME varchar(100) NOT NULL,\n" +
                    "USER_LAST_NAME varchar(100) NOT NULL,\n" +
                    "USER_EMAIL varchar(150) UNIQUE NOT NULL,\n" +
                    "USER_ROLE_ID int REFERENCES ERS_USER_ROLES(ERS_USER_ROLE_ID) ON DELETE CASCADE NOT NULL\n" +
                    ")\n" +
                    "CREATE TABLE ERS_REIMBURSEMENT(\n" +
                    "REIMB_ID serial PRIMARY KEY,\n" +
                    "REIMB_AMOUNT double PRECISION NOT NULL,\n" +
                    "REIMB_SUBMITTED timestamp NOT NULL,\n" +
                    "REIMB_RESOLVED timestamp,\n" +
                    "REIMB_DESCRIPTION varchar(250),\n" +
                    "REIMB_RECEIPT bytea,\n" +
                    "REIMB_AUTHOR int REFERENCES ERS_USERS(ERS_USERS_ID) ON DELETE CASCADE NOT NULL,\n" +
                    "REIMB_RESOLVER int REFERENCES ERS_USERS(ERS_USERS_ID) ON DELETE CASCADE,\n" +
                    "REIMB_STATUS_ID int REFERENCES ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID) ON DELETE CASCADE DEFAULT (0),\n" +
                    "REIMB_TYPE_ID int REFERENCES ERS_REIMBURSEMENT_TYPE(REIMB_TYPE_ID) ON DELETE CASCADE NOT NULL\n" +
                    ")";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void dropTable(){
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DROP TABLE ERS_USER_ROLES cascade;\n" +
                    "DROP TABLE ERS_REIMBURSEMENT_STATUS cascade;\n" +
                    "DROP TABLE ERS_REIMBURSEMENT_TYPE cascade;\n" +
                    "DROP TABLE ERS_USERS cascade;\n" +
                    "DROP TABLE ers_reimbursement cascade;";
            //String sql2 = "DROP TABLE accounts;";

            PreparedStatement ps = conn.prepareStatement(sql);
            //PreparedStatement x = conn.prepareStatement(sql2);
            //x.executeUpdate();
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
