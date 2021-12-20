package frontcontroller;

import controllers.ReimbursementController;
import controllers.UserController;
import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.*;

public class Dispatcher {
    public Dispatcher(Javalin app) {
        app.routes(() -> {
            path("employeepage", () -> {
                get(ReimbursementController::getAllReimbursements);
                /*get(ReimbursementController::pending);
                get(ReimbursementController::approved);
                get(ReimbursementController::denied);*/
                post(ReimbursementController::createReimbursement);
                    //get(ReimbursementController::getReimbursement);
                path("{id}", () -> {
                    get(ReimbursementController::employeeReimbs);
                    //get(ReimbursementController::emppending);
                });
            });
            path("managerpage", () -> {
                post(UserController::createUser);
                patch(ReimbursementController::approveDeny);
                delete(UserController::deleteUser);
            });
            path("login", () -> {
                post(UserController::login);
                get(UserController::checkSession);
                delete(UserController::logout);
            });
            path("user", () -> {
                post(UserController::user);
            });
            path("userid", () -> {
                post(UserController::userId);
            });
        });
    }
}
