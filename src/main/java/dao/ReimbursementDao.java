package dao;

import models.Reimbursement;
import models.UserRole;

import io.javalin.http.Context;
import java.util.List;

public interface ReimbursementDao {
    List<Reimbursement> getAllReimbursements(Context context);
    List<Reimbursement> employeeReimbs(Integer reimb, Context context);
    //Reimbursement getReimbursement(Integer reimbid);
    void createReimbursement(Reimbursement reimb);
    void approveDeny(Reimbursement reimb);
    /*List<Reimbursement> emppending(Integer authid);
    List<Reimbursement>pending();
    List<Reimbursement> approved();
    List<Reimbursement> denied();*/
    //void deleteClient(Integer accountId);
}
