package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Vladimir", "Bocharov", (byte) 36);
//        userService.removeUserById(6);
//        userService.dropUsersTable();
//        userService.cleanUsersTable();
        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
        Util.closeConnection();
    }
}
