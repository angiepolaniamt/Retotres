/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.usa.ciclo4.com.usa.ciclo4.crud;

import com.usa.ciclo4.com.usa.ciclo4.model.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author angie
 */
public interface GadgetCrudRepository extends MongoRepository<Gadget,Integer>{
    
}
