package test;


import com.SpringBootDemo;
import com.entity.Projects;
import com.service.BidService;
import com.service.ProjectService;
import com.service.UserService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootDemo.class)
public class FreelancerTest {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    BidService bidService;


    @Test
    public void UserLoginTrue() {
        JSONObject jsonObject = userService.login("sunil","sunil");
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.getJSONArray("user"));
        JSONArray jsonArray=jsonObject.getJSONArray("user");
        JSONObject loginObj=(JSONObject)jsonArray.get(0);
        System.out.println(loginObj.getString("name"));
        if(loginObj.getString("name").equals("sunil"))
        {
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void getAllProjects() {
        List<Projects> projects = projectService.getAllProjects(4);
        System.out.println(projects.get(0));

        if(projects.get(0)!=null)
        {
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void getDashboardProjectsBidsOn() {
        JSONObject jsonObject = projectService.getDashboardProjects(4);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.getJSONArray("projectsBidOn"));
        JSONArray jsonArray=jsonObject.getJSONArray("projectsBidOn");
        JSONObject loginObj=(JSONObject)jsonArray.get(0);
        System.out.println(loginObj.getInt("project_id"));
        if(loginObj.getInt("project_id")==2)
        {
            assert true;
        }
        else {
            assert false;
        }
    }

    @Test
    public void getDashboardProjectsEmployer() {
        JSONObject jsonObject = projectService.getDashboardProjects(4);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.getJSONArray("projectsAsEmployer"));
        JSONArray jsonArray=jsonObject.getJSONArray("projectsAsEmployer");
        JSONObject loginObj=(JSONObject)jsonArray.get(0);
        System.out.println(loginObj.getInt("project_id"));
        if(loginObj.getInt("project_id")==29)
        {
            assert true;
        }
        else {
            assert false;
        }
    }


    @Test
    public void getListOfAllBids() {
        JSONObject jsonObject = bidService.getListOfAllBids(27);
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.getJSONArray("bids"));
        JSONArray jsonArray=jsonObject.getJSONArray("bids");
        JSONObject loginObj=(JSONObject)jsonArray.get(0);
        System.out.println(loginObj.getInt("bid"));
        if(loginObj.getInt("bid")==1200)
        {
            assert true;
        }
        else {
            assert false;
        }
    }




}
