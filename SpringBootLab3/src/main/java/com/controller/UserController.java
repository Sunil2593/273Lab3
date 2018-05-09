package com.controller;

import com.service.BidService;
import com.service.ProjectService;
import com.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/operations") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private BidService bidService;


 /*   @PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> loginNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userService.loginUser(user);
        System.out.println("LoggedIn");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }*/

   /* @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userService.addUser(user);
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }

    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON with the users
        return userService.getAllUsers();
    }
*/
    @PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String body, HttpSession session)
    {
        System.out.println("body is:"+ body);
        JSONObject jsonObject = new JSONObject(body);
        session.setAttribute("name",jsonObject.getString("username"));
        return new ResponseEntity(userService.login(jsonObject.getString("username"),jsonObject.getString("password")).toString(),HttpStatus.OK);
    }

    @PostMapping(path="/getListOfAllBids",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListOfAllBids(@RequestBody String body, HttpSession session)
    {
        System.out.println("body is:"+ body);
        JSONObject jsonObject = new JSONObject(body);
        return new ResponseEntity(bidService.getListOfAllBids(jsonObject.getInt("projectId")).toString(),HttpStatus.OK);
    }

    @PostMapping(path="/getListOfAllProjectsAsEmployer",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getListOfAllProjectsAsEmployer(@RequestBody String body, HttpSession session)
    {
        System.out.println("body is:"+ body);
        JSONObject jsonObject = new JSONObject(body);
        return new ResponseEntity(projectService.getDashboardProjects(jsonObject.getInt("user_id")).toString(),HttpStatus.OK);
    }

    @PostMapping(path="/updateProfile",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfile(@RequestBody String body, HttpSession session)
    {
        System.out.println("body is:"+ body);
        JSONObject jsonObject = new JSONObject(body);
        return new ResponseEntity(userService.updateProfile(jsonObject.getString("name"),jsonObject.getString("phone_no"),jsonObject.getString("about_me"),jsonObject.getString("skills"),jsonObject.getInt("user_id")).toString(),HttpStatus.OK);
    }

    @PostMapping(path="/postProjects",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postProjects(@RequestBody String body, HttpSession session)
    {
        System.out.println("body is:"+ body);
        JSONObject jsonObject = new JSONObject(body);
        return new ResponseEntity(projectService.postProject(jsonObject.getString("name"),jsonObject.getString("description"),jsonObject.getString("skillsRequired"),Integer.parseInt(jsonObject.getString("budgetRange")),jsonObject.getString("status"),jsonObject.getString("estimateProjectCompletionDate"),jsonObject.getInt("owner")).toString(),HttpStatus.OK);
    }

    @GetMapping(path="/hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> hello()
    {
        System.out.println("Hello");
        return new ResponseEntity(HttpStatus.OK);
    }

    /*@PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("name"));
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }*/
}