package tutorial.domain.service.oderitem;

import java.util.Collection;

import tutorial.domain.model.Item;

public interface OrderItemService {
    
    Collection<Item> findAll();

}
