package com.service;

import com.entity.Projects;
import com.entity.Users;
import com.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectService projectService;


    public Iterable<Users> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(Users user){
        userRepository.save(user);
    }

    public void loginUser(Users user){
        userRepository.save(user);
    }

    public JSONObject login(String email,String password){
        List<Users> users = userRepository.findByEmailAndPassword(email,password);
        System.out.println(users.get(0).getUser_id());
        List<Projects> projects = projectService.getAllProjects(users.get(0).getUser_id());
        JSONObject obj = new JSONObject();
        obj.put("user", users);
        obj.put("projects", projects);
        return obj;
    }

    public JSONObject updateProfile(String name,String phoneNo,String aboutMe,String skills,Integer userId){
        userRepository.updateProfile(name,phoneNo,aboutMe,skills,userId);
        JSONObject obj = new JSONObject();
        obj.put("dataUpdation", true);
        return obj;
    }
}