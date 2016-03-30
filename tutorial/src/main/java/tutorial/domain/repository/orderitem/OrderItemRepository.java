package tutorial.domain.repository.orderitem;

import java.util.Collection;

import tutorial.domain.model.Item;

public interface OrderItemRepository {
    
    Collection<Item> findAll();

}
