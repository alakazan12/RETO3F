
package com.usa.reto2.Crud;

import com.usa.reto2.Modelos.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface OrderInterface extends MongoRepository<Order, Integer> {
    @Query("{'salesMan.zone':?0}")
    public List<Order> findUserByZone(String zone);
    
    
}
