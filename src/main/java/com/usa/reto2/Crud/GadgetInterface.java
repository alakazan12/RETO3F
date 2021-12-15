
package com.usa.reto2.Crud;

import com.usa.reto2.Modelos.Gadget;
import org.springframework.data.mongodb.repository.MongoRepository;




public interface GadgetInterface extends MongoRepository<Gadget, Integer> {
    
    
    
}
