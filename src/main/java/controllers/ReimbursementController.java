package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.Context;
import models.Reimbursement;
import services.ReimbursementService;

import java.util.List;

public class ReimbursementController {
    static ReimbursementService reimbService = new ReimbursementService();

    public static void getAllReimbursements(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        //Reimbursement reimb2 = context.bodyAsClass(Reimbursement.class);
        List<Reimbursement> reimbList = reimbService.getAllReimbursements(context);
        String jsonString = new ObjectMapper().writeValueAsString(reimbList);
        context.result(jsonString);
    }

    public static void createReimbursement(Context context) {
        Reimbursement info = context.bodyAsClass(Reimbursement.class);
        if(reimbService.createReimbursement(info)==true){
            context.result("client created");
        }
    }

    public static void employeeReimbs(Context context) throws JsonProcessingException {
        context.contentType("application/json");
        //Reimbursement reimb = context.bodyAsClass(Reimbursement.class);
        Integer reimbId = Integer.parseInt(context.pathParam("id"));
        List<Reimbursement> reimbList = reimbService.employeeReimbs(reimbId, context);
        context.result(new ObjectMapper().writeValueAsString(reimbList));
    }

    public static void approveDeny(Context context) throws JsonProcessingException {
        Reimbursement reimb = context.bodyAsClass(Reimbursement.class);
        //Integer reimbId = Integer.parseInt(context.pathParam("id"));
        if(reimbService.approveDeny(reimb) == true)
        context.result("Request with reimbursement id " + reimb.getReimbid() + " has been changed");
        else
            context.result("Error Updating");
    }
}
