package com.repository;

import com.entity.Users;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface UserRepository extends CrudRepository<Users, Long> {
    List<Users> findByEmailAndPassword(String email,String password);

    @Modifying
    @Query("update Users set name=?1, phone_no=?2, about_me=?3, skills=?4 where user_id=?5")
    void updateProfile(String name, String phone_no, String about_me, String skills, Integer user_id);
}