

package com.usa.reto2.Repository;

import com.usa.reto2.Crud.OrderInterface;
import com.usa.reto2.Modelos.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class OrderRepo {
    
    @Autowired
    private OrderInterface inter;
    
    public List<Order> getAll() {
        return inter.findAll();
    }
    
    public Optional<Order> findById(Integer id) {
        return inter.findById(id);
    }
    
     public List<Order> findUserByZone(String zone) {
        return inter.findUserByZone(zone);
    }
    
    public Order save(Order order) {
        return inter.save(order);
    }
    
    public void deleteById(Integer id) {
        inter.deleteById(id);
    }
    
    
}
