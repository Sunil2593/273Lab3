package com.repository;

import com.entity.Bid;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface BidRepository extends CrudRepository<Bid, Long> {
    /*List<Bid> findByEmailAndPassword(String email,String password);*/

    @Query(value = "Select * from bid inner join users where bid.user_id=users.user_id and users.user_id in (Select user_id from bid where project_id = ?1)", nativeQuery = true)
    public List<Bid> findListOfAllBidsOnProject(@Param("project_id") long project_id);

}