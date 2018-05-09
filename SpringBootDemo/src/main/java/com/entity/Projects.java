package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;


@Entity // This tells Hibernate to make a table out of this class
public class Projects {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)


    private Integer project_id;

    private Integer user_id;

    private String name;

    private String description;

    private String skills_required;

    private Integer budget_range;

    private String status;

    private Date estimate_project_completion_date;

    private String project_given_to;

    public Integer getProject_id() {
        return project_id;
    }

    public void setProject_id(Integer project_id) {
        this.project_id = project_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSkills_required() {
        return skills_required;
    }

    public void setSkills_required(String skills_required) {
        this.skills_required = skills_required;
    }

    public Integer getBudget_range() {
        return budget_range;
    }

    public void setBudget_range(Integer budget_range) {
        this.budget_range = budget_range;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEstimate_project_completion_date() {
        return estimate_project_completion_date;
    }

    public void setEstimate_project_completion_date(Date estimate_project_completion_date) {
        this.estimate_project_completion_date = estimate_project_completion_date;
    }

    public String getProject_given_to() {
        return project_given_to;
    }

    public void setProject_given_to(String project_given_to) {
        this.project_given_to = project_given_to;
    }
}