package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.HibernateUtil;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

//        userService.createUsersTable();
        userService.saveUser("1", "2", (byte) 3);
        userService.saveUser("2", "3", (byte) 4);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
