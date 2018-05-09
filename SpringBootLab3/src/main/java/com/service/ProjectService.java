package com.service;

import com.entity.Projects;
import com.repository.ProjectsRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectsRepository projectsRepository;

    public Iterable<Projects> getAllUsers(){
        return projectsRepository.findAll();
    }

    public void addUser(Projects project){
        projectsRepository.save(project);
    }

    public List<Projects> getAllProjects(int user_id){
        List<Projects> projects=projectsRepository.findByNotUserId(user_id);
        return projects;
    }


    public JSONObject getDashboardProjects(int userId){
        List<Projects> projectsBidOn=projectsRepository.getListOfAllProjectsBidOn(userId);
        List<Projects> projectsAsEmployer=projectsRepository.getListOfAllProjectsAsEmployer(userId);
        JSONObject obj = new JSONObject();
        obj.put("projectsBidOn", projectsBidOn);
        obj.put("projectsAsEmployer", projectsAsEmployer);
        return obj;
    }

    public JSONObject postProject(String name,String description,String skills,Integer budgetRange,String status,String date,Integer userId){

        Projects myProject=new Projects();

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-DD");
        date=date.substring(0 , 9);
        Date dateIssue=null;
        try {
            dateIssue = formatter.parse(date);
            System.out.println(dateIssue);
            System.out.println(formatter.format(dateIssue));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        myProject.setName(name);
        myProject.setDescription(description);
        myProject.setSkills_required(skills);
        myProject.setProject_id(0);
        myProject.setUser_id(userId);
        myProject.setEstimate_project_completion_date(dateIssue);
        myProject.setStatus(status);
        myProject.setBudget_range(budgetRange);

        projectsRepository.save(myProject);
        JSONObject obj = new JSONObject();
        obj.put("postProject", true);
        return obj;
    }



}