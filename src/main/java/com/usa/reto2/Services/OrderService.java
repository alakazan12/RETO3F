
package com.usa.reto2.Services;

import com.usa.reto2.Modelos.Order;
import com.usa.reto2.Repository.OrderRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepo repo;
    
    public List<Order> getAll() {
        return repo.getAll();
    }
    
    public List<Order> getByZone(String zone) {
        return repo.findUserByZone(zone);
    }
    
    public Order getById(Integer id) {
        Optional<Order> order = repo.findById(id);
        if (order.isPresent()) {
         return order.get();
        }
          return new Order();
    }
    
    public Order save(Order order) { // Strings && Integer boolean
        if (order.getRegisterDay() == null || order.getStatus()== null ||
        order.getSalesMan()== null || order.getProducts()== null ||
        order.getQuantities()== null) {
        return order;
            
        } else {
            Optional<Order> orderCrud = repo.findById(order.getId());
            if (orderCrud.isEmpty()) {
                return repo.save(order);
                
            } return order;
            
        }
        
    }
    
    public Order update(Order order){
        if (order.getId() != null) {
            Optional<Order> orderUpdate = repo.findById(order.getId());
            if (orderUpdate.isPresent()) {
                if(order.getRegisterDay() != null) {
                    orderUpdate.get().setRegisterDay(order.getRegisterDay());
                    
                } if(order.getStatus()!= null) {
                    orderUpdate.get().setStatus(order.getStatus());
                }
                if(order.getSalesMan()!=null){
                    orderUpdate.get().setSalesMan(order.getSalesMan());
                }
                
                if(order.getProducts()!=null){
                    orderUpdate.get().setProducts(order.getProducts());
                }
                if(order.getQuantities()!=null){
                    orderUpdate.get().setQuantities(order.getQuantities());
                }
                
                
                return repo.save(orderUpdate.get());
                
            } else { 
                return order;
            }
            
        } else {
            return order;
        }
        
    }
    
    
    public boolean delete(Integer id) {
        Optional<Order> order = repo.findById(id);
        if (order.isPresent()) {
            repo.deleteById(id);
            return true;
            
        } return false;
        
    }
    
    
    
}
