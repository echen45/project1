package dao;

import io.javalin.http.Context;
import models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.H2Util;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReimbursementDaoImplTestIT {
    Context context;
    ReimbursementDao reimbDao;
    UserDao userDao;
    UserRoleDao userRoleDao;
    ReimbursementTypeDao reimbTypeDao;
    ReimbursementStatusDao reimbStatDao;

    public ReimbursementDaoImplTestIT(){
        this.reimbDao = new ReimbursementDaoImpl(H2Util.url,H2Util.username,H2Util.password);
        this.userDao = new UserDaoImpl(H2Util.url,H2Util.username,H2Util.password);
        this.userRoleDao = new UserRoleDaoImpl(H2Util.url,H2Util.username,H2Util.password);
        this.reimbTypeDao = new ReimbursementTypeDaoImpl(H2Util.url,H2Util.username,H2Util.password);
        this.reimbStatDao = new ReimbursementStatusDaoImpl(H2Util.url,H2Util.username,H2Util.password);
    }

    @BeforeEach
    void setUp() {H2Util.createTable();}

    @AfterEach
    void tearDown() {H2Util.dropTable();}

    @Test
    void getAllReimbursements() {
        UserRole userrole = new UserRole();
        userRoleDao.createUserRole();
        ReimbursementStatus reimbstat = new ReimbursementStatus();
        reimbStatDao.createReimbursementStatus();
        ReimbursementType reimbtype = new ReimbursementType();
        reimbTypeDao.createReimbursementType();
        User user = new User(1,"jcole5", "john", "cole", "jcole@rev.com", 0 );
        userDao.createUser(user);
        //Reimbursement reimb = new Reimbursement();
        List<Reimbursement> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursement(1, 20, "2021-12-10 16:17:12.370", "2021-12-10 16:17:12.370", "went to burger king",1,1,0,0));
        //expectedResult.add(new Reimbursement(2, 40, "2021-12-10 16:17:12.371", "2021-12-10 16:17:12.371", "tacobell", 1,1,1,1));
        //expectedResult.add(new Reimbursement(3, 60, "2021-12-10 16:17:12.372", "2021-12-10 16:17:12.372", "place",1,1,1,1));
        reimbDao.createReimbursement(expectedResult.get(0));
        //reimbDao.createReimbursement(expectedResult.get(1));
        //reimbDao.createReimbursement(expectedResult.get(2));
        List<Reimbursement> actualResult = reimbDao.getAllReimbursements(context);
        assertEquals(expectedResult,actualResult);
    }
/*
    @Test
    void createReimbursement() {
        List<Reimbursement> expectedResult = new ArrayList<>();
        expectedResult.add(new Reimbursement(1,"sweep"));
        expectedResult.add(new Reimbursement(2,"mop"));
        expectedResult.add(new Reimbursement(3,"vacuum"));
        reimbDao.createReimbursement(expectedResult.get(0));
        reimbDao.createReimbursement(expectedResult.get(1));
        reimbDao.createReimbursement(expectedResult.get(2));

        //act
        Reimbursement actualResult = reimbDao.getAllReimbursements();


        //assert
        assertEquals(expectedResult.get(1),actualResult);
    }*/
}