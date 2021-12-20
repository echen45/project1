package services;

import dao.UserDao;
import models.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserDao userDao = Mockito.mock(UserDao.class);
    UserService userService;
    public UserServiceTest(){
        this.userService = new UserService(userDao);
    }

    @Test
    void createUser() {
        User user = new User(1, "ersusername", "firstname", "userlastname", "useremail", 0);
        userService.createUser(user);
        Mockito.verify(userDao, Mockito.times(1)).createUser(user);
    }

    @Test
    void deleteUser() {
        User user = new User(1, "ersusername", "firstname", "userlastname", "useremail", 0);
        userService.deleteUser(user);
        Mockito.verify(userDao, Mockito.times(1)).deleteUser(user);
    }

    @Test
    void compareData() {
        User user = new User(1, "ersusername", "firstname", "userlastname", "useremail", 0);
        Mockito.when(userDao.compareData(user)).thenReturn(true);
        Boolean actualresult= userService.compareData(user);
        assertTrue(actualresult);
    }

    @Test
    void compareData2() {
        User user = new User(1, "ersusername", "firstname", "userlastname", "useremail", 0);
        Mockito.when(userDao.compareData(user)).thenReturn(false);
        Boolean actualresult= userService.compareData(user);
        assertFalse(actualresult);
    }

    @Test
    void user() {
        User user = new User(1, "ersusername", "firstname", "userlastname", "useremail", 0);
        int expectedvalue =1;
        Mockito.when(userDao.user(user)).thenReturn(1);
        int actualresult= userService.user(user);
        assertEquals(expectedvalue,actualresult);
    }

    @Test
    void userId() {
        User user = new User(1, "ersusername", "firstname", "userlastname", "useremail", 0);
        int expectedvalue =0;
        Mockito.when(userDao.userId(user)).thenReturn(0);
        int actualresult= userService.userId(user);
        assertEquals(expectedvalue,actualresult);
    }
}