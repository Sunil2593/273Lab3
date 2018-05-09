package com.server.test;

import com.entity.FileDetails;
import com.entity.FileOperationLogs;
import com.entity.ShareData;
import com.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FreelancerTest {

    @Autowired
    UserService userService;

    @Autowired
    Project fileService;



    public void setUp(){

    }

    public void tearDown(){

    }

    @Test
    public void UserLoginTrue() {
        List<User> userList = userService.login("sunil","sunil");
        System.out.println(userList);
        if(userList.size()==1){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void FindUserByEmail() {
        List<User> userList = userService.findByEmail("sunil");
        System.out.println(userList);
        if(userList.size()==1){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void findUsers()
    {
        Iterable<User> userList = userService.getAllUsers();
        System.out.println(userList);
        if(userList.spliterator().getExactSizeIfKnown()>0)
        {
            assert true;
        }
        else {
            assert false;
        }
    }
    @Test
    public void UserLoginFalse() {
        List<User> userList = userService.login("m@m.com",userService.generateHash("m"));
        System.out.println(userList);
        if(userList.size()==0){
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void getUserProfile() {
        User user = profileService.fetchProfile(34);
        System.out.println(user);
        if(user!=null){
            assert true;
        }
        else {
            assert false;
        }
    }

}
