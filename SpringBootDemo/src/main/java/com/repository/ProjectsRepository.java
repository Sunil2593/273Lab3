package com.repository;

import com.entity.Projects;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface ProjectsRepository extends CrudRepository<Projects, Long> {
    List<Projects> findAll();

    @Query(value = "Select * from projects where status='Not Hired' and user_id not in(?1)", nativeQuery = true)
    public List<Projects> findByNotUserId(@Param("user_id") long user_id);

    @Query(value = "Select * from projects inner join bid where projects.project_id=bid.project_id and projects.project_id in (Select project_id from bid where user_id = ?1) and bid.user_id=?1", nativeQuery = true)
    public List<Projects> getListOfAllProjectsBidOn(@Param("user_id") long user_id);

    @Query(value = "Select * from projects where user_id = ?1", nativeQuery = true)
    public List<Projects> getListOfAllProjectsAsEmployer(@Param("user_id") long user_id);


}