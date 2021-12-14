/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.com.usa.ciclo4.controllers;

import com.usa.ciclo4.com.usa.ciclo4.model.User;
import com.usa.ciclo4.com.usa.ciclo4.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author angie
 */
@RestController
@RequestMapping("api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    @Autowired
    /**
     * trae el servicio
     */
    private UserService userService;
    
    @GetMapping("/all")
    /**
     * obtenerlos todos
     */
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    /**
     * obtener un usuario desde la id
     */
    public Optional <User> getUser(@PathVariable("id") int id) {
        return userService.getUser(id);
    }
    
    @PostMapping("/new")
    /**
     * Crear un usuario nuevo
     */
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * actualizar los datos del usuario
     */
    public User update(@RequestBody User user){
        return userService.update(user);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * Borrar el usuario desde su id
     */
    public boolean delete(@PathVariable("id")int id){
        return userService.delete(id);
    }
    
     @GetMapping("/{email}/{password}")
     /**
      * comprobar el mail y la pw para autenticarlo
      */
    public User authenticateUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticatedUser(email,password);
    }

    @GetMapping("/emailexist/{email}")
    /**
     * Verificar si un usuario se habia registrado antes con ese mail
     */
    public boolean emailExists (@PathVariable("email") String email){
        return userService.emailExists(email);
    }
}
