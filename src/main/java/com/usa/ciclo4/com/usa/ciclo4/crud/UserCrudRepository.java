/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.ciclo4.com.usa.ciclo4.crud;

import com.usa.ciclo4.com.usa.ciclo4.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author angie
 */
public interface UserCrudRepository extends MongoRepository<User,Integer>{
    
    Optional<User> findByEmail(String email);
    //List<User> findBybirthDay(Date date);
    Optional<User> findByEmailAndPassword(String email, String password);
   // Optional<User> findByNameOrEmail(String name, String email);
    Optional<User> findTopByOrderByIdDesc();
}
