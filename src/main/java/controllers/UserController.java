package controllers;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import io.javalin.http.Context;
import models.JsonResponse;
import models.Reimbursement;
import models.User;
import models.UserDTO;
import services.ReimbursementService;
import services.UserService;

public class UserController {
    static UserService userService = new UserService();

    public static void createUser(Context context) {
        User info = context.bodyAsClass(User.class);
        if(userService.createUser(info)==true){
            context.result("user created");
        }
    }

    public static void deleteUser(Context context) {
        User info = context.bodyAsClass(User.class);
        //Integer userid = Integer.parseInt(context.pathParam("id"));
        if(userService.deleteUser(info)==true)
            context.result("user deleted");
        else
            context.result("Failed to delete");
        /*if (userService.getUser(userid)==null)
        context.result("Deleted account with id " + userid);
        */
    }

    public static void login(Context context) {
        User info = context.bodyAsClass(User.class);
        //if(userService.login(info)==true){
        if(userService.compareData(info)==true) {
            context.sessionAttribute("user-session", info);
            context.json(new JsonResponse(true, "login successful", new UserDTO(info.getErsusername()/*, info.getRole()*/)));
        } else{
            context.json(new JsonResponse(false, "no session found", null));
        }
        }

    public static void checkSession(Context context) {
        User user = context.sessionAttribute("user-session");
        if(user == null){
            context.json(new JsonResponse(false, "no session found", null));
        }else{
            context.json(new JsonResponse(true, "session found", new UserDTO(user.getErsusername()/*, user.getRole()*/)));
        }
    }

    public static void logout(Context context) {
        context.sessionAttribute("user-session",null);
        context.json(new JsonResponse(true, "Session has been destroyed and you have successfully logged out", null));
    }

    public static void userId(Context context) {
        User info = context.bodyAsClass(User.class);
        context.json(userService.userId(info));
        //context.json(new JsonResponse(true, "login successful", new UserDTO(info.getErsusername(), info.getRole())));
    }

    public static void user(Context context) {
        User info = context.bodyAsClass(User.class);
        context.json(userService.user(info));
    }
}

