package services;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import dao.UserDao;
import dao.UserDaoImpl;
import io.javalin.http.Context;
import models.User;

public class UserService {
    UserDao userDao;
    public UserService(){this.userDao = new UserDaoImpl();}
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public boolean createUser(User info) {
        userDao.createUser(info);
        return true;
    }

    public boolean deleteUser(User info) {
        userDao.deleteUser(info);
        return true;
    }

    public boolean compareData(User info) {
        if (userDao.compareData(info) == true)
            return true;
        return false;
    }

    public int userId(User info) {
       return userDao.userId(info);
    }

    public int user(User info) {
        return userDao.user(info);
    }
}
