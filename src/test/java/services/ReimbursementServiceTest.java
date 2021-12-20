package services;

import dao.ReimbursementDao;
import dao.UserDao;
import io.javalin.http.Context;
import models.Reimbursement;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementServiceTest {
    ReimbursementDao reimbDao = Mockito.mock(ReimbursementDao.class);
    ReimbursementService reimbService;
    public ReimbursementServiceTest(){
        this.reimbService = new ReimbursementService(reimbDao);
    }

    @Test
    void getAllReimbursements() {
        Context context = null;
        List<Reimbursement> reimb = new ArrayList<>();
        reimb.add(new Reimbursement(1, 20, "2021-12-12 14:46:33.541", "2021-12-12 14:46:33.551", "lunch", 1, 2, 0, 2));
        reimb.add(new Reimbursement(2, 40, "2021-12-12 14:46:33.542", "2021-12-12 14:46:33.552", "gas", 1, 2, 0, 1));
        reimb.add(new Reimbursement(3, 60, "2021-12-12 14:46:33.543", "2021-12-12 14:46:33.553", "dinner", 1, 2, 0, 2));
        List<Reimbursement> expectedValue = reimb;
        Mockito.when(reimbDao.getAllReimbursements(context)).thenReturn(reimb);
        List<Reimbursement> actualResult = reimbService.getAllReimbursements(context);
        assertEquals(expectedValue,actualResult);
    }

    @Test
    void createReimbursement() {
        Reimbursement reimb = new Reimbursement(1, 20, "2021-12-12 14:46:33.541", "2022-12-12 14:46:33.541", "lunch", 1, 2, 0, 2);
        reimbService.createReimbursement(reimb);
        Mockito.verify(reimbDao, Mockito.times(1)).createReimbursement(reimb);
    }

    @Test
    void employeeReimbs() {
        Context context =null;
        Integer authid =1;
        List<Reimbursement> reimb = new ArrayList<>();
        reimb.add(new Reimbursement(1, 20, "2021-12-12 14:46:33.541", "2021-12-12 14:46:43.541", "lunch", 1, 2, 0, 2));
        reimb.add(new Reimbursement(2, 40, "2021-12-12 14:46:33.542", "2021-12-12 14:46:43.542", "gas", 1, 2, 0, 1));
        reimb.add(new Reimbursement(3, 60, "2021-12-12 14:46:33.543", "2021-12-12 14:46:43.543", "dinner", 1, 2, 0, 2));
        List<Reimbursement> expectedValue = reimb;
        Mockito.when(reimbDao.employeeReimbs(authid,context)).thenReturn(reimb);
        List<Reimbursement> actualResult = reimbService.employeeReimbs(authid, context);
        assertEquals(expectedValue,actualResult);
    }

    @Test
    void approveDeny() {
        Reimbursement x = new Reimbursement(1, 20, "2021-12-12 14:46:33.541", "2022-12-12 14:46:33.541", "lunch", 1, 2, 0, 2);
        reimbService.approveDeny(x);
        Mockito.verify(reimbDao, Mockito.times(1)).approveDeny(x);
    }
}