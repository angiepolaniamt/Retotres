/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.com.usa.ciclo4.repository;

import com.usa.ciclo4.com.usa.ciclo4.crud.OrderCrudRepository;
import com.usa.ciclo4.com.usa.ciclo4.model.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author angie
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    public List<Order> getAll(){
        return (List<Order>) orderCrudRepository.findAll();
    }
    
    public Optional<Order> getOrder(int id){
        return orderCrudRepository.findById(id);
    }
    
    //Crear
    public Order create(Order order){
        return orderCrudRepository.save(order);
    }
    
    public void update (Order order){
        orderCrudRepository.save(order);
    }
    
    public void delete (Order order){
        orderCrudRepository.delete(order);
    }
    
    public Optional<Order> idMaximo(){
        return orderCrudRepository.findTopByOrderByIdDesc();
    }
    
    //buscar por zona
    public List <Order> findZone(String zona){
        return orderCrudRepository.findByZone(zona);
    }
    
    public List<Order> status(String status){
        return orderCrudRepository.findByStatus(status);
    }
}
