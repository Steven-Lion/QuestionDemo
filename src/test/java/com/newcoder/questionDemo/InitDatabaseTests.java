package com.newcoder.questionDemo;
import DAO.UserDAO;
import model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Random;

/**
 * Created by Steven on 12/08/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootConfiguration
@Sql("/com/newcoder/questionDemo/init-schema.sql")
@Repository
public class InitDatabaseTests {
    @Autowired
    UserDAO userDAO;
    @Test
    public void Contextsloads(){
//        System.out.print("hello!");

        Random random = new Random();

        for (int i = 0 ;i <=5 ;i++) {

            User user = new User();

            user.setName(String.format("User_%d", i));
            user.setPassword("");
            user.setSalt("");
            user.setHead_url(String.format("http://images.nowcoder.com/head/%dt.png", random.nextInt(1000)));
            userDAO.addUser(user);
        }

    }
}
