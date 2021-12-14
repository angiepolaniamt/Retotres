/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.ciclo4.com.usa.ciclo4.service;

import com.usa.ciclo4.com.usa.ciclo4.model.Gadget;
import com.usa.ciclo4.com.usa.ciclo4.model.Order;
import com.usa.ciclo4.com.usa.ciclo4.repository.OrderRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angie
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll(){
        return orderRepository.getAll();
    }
    
    //Traer dato individual
    public Optional<Order> getOrder(int id){
        return orderRepository.getOrder(id);
    }
    
    // Crear
    public Order create(Order order){
       Optional<Order> orderIdMax= orderRepository.idMaximo();
       if(order.getId()==null){
           if(orderIdMax.isEmpty()){
           order.setId(1);
           }else {
           order.setId(orderIdMax.get().getId()+1);
           }
       }
       Optional<Order> datos = orderRepository.getOrder(order.getId());
       if(datos.isEmpty()){
           return orderRepository.create(order);
       }else{
           return order;
       }
       
    }
    public Order update(Order order){
        if(order.getId()!=null){
            Optional<Order> datos = orderRepository.getOrder(order.getId());
            if(datos.isPresent()){
                if(order.getStatus() !=null){
                    datos.get().setStatus(order.getStatus());
                    
                }
                orderRepository.update(datos.get());
                return datos.get();
            }
            return order;
        }
        return order;
    }
    
    public boolean delete(int id){
        Boolean verificacion = getOrder(id).map(orden ->{
           orderRepository.delete(orden);
           return true;
        }).orElse(false);
        return verificacion;
    }
    
    public List<Order> findZone(String zone){
        return orderRepository.findZone(zone);
    }
    /**
     * Agregar una cantidad a la orden
     * @param idOrder
     * @param quantity
     * @return 
     */
    public Order editQuantity(Integer idOrder, Integer quantity){
        Optional<Order> exist = orderRepository.getOrder(idOrder);
            Map<Integer, Integer> quantities = exist.get().getQuantities();
            Integer var = 0;
            Set<Integer> keys = quantities.keySet();
            ArrayList<Integer> claves = new ArrayList<>();
            for (Integer key : keys) {
                claves.add(key);
            }
            Collections.sort(claves);
            int mayorKey = 0;
            
            for (Integer clave : claves) {
               
                if (clave > mayorKey) {
                    mayorKey = clave;
                }
            }
            var = mayorKey+1;

            quantities.put(var,quantity);
            exist.get().setQuantities(quantities);
            return orderRepository.create(exist.get());
          
    }
}
