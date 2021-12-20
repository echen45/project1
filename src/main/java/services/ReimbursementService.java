package services;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import io.javalin.http.Context;
import models.Reimbursement;

import java.util.List;

public class ReimbursementService {
    ReimbursementDao reimbDao;
    public ReimbursementService(){this.reimbDao = new ReimbursementDaoImpl();}
    public ReimbursementService(ReimbursementDao reimbDao){
        this.reimbDao = reimbDao;
    }

    public List<Reimbursement> getAllReimbursements(Context context) {
        return reimbDao.getAllReimbursements(context);}

    public boolean createReimbursement(Reimbursement info) {
        reimbDao.createReimbursement(info);
        return true;
    }

    public List<Reimbursement> employeeReimbs( Integer reimbid, Context context) {
        return reimbDao.employeeReimbs(reimbid, context);
    }

    public boolean approveDeny(Reimbursement reimb) {
        reimbDao.approveDeny(reimb);
        return true;
    }
}
