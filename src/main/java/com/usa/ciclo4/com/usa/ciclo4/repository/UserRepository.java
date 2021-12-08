/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.com.usa.ciclo4.repository;

import com.usa.ciclo4.com.usa.ciclo4.crud.UserCrudRepository;
import com.usa.ciclo4.com.usa.ciclo4.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angie
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    
    public Optional<User> getUser(int id){
       return userCrudRepository.findById(id);
    }
    
    public User save(User user){
        return userCrudRepository.save(user);
    }
    
    public void update(User user){
        userCrudRepository.save(user);
    }
    
    public void delete(User user){
        userCrudRepository.delete(user);
    }
    
    public boolean emailExists(String email){
        Optional<User> user = userCrudRepository.findByEmail(email);
        return user.isPresent();
    }
    
    public Optional<User> authenticatedUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> idMaximo(){
        return userCrudRepository.findTopByOrderByIdDesc();
    }
}
