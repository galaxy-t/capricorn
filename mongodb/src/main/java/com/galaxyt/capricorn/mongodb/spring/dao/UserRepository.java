package com.galaxyt.capricorn.mongodb.spring.dao;

import com.galaxyt.capricorn.mongodb.spring.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface UserRepository extends CrudRepository<User,String> {


    User findByName(String name);


    User findByName(String name, Pageable pageable);




}
