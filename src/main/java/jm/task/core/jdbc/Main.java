package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.HibernateUtil;
import jm.task.core.jdbc.util.Util;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserServiceImpl userService = new UserServiceImpl();

//        userService.cleanUsersTable();
        userService.createUsersTable();


        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

    }
}
