package tutorial.domain.repository.order;

import java.util.Collection;

import tutorial.domain.model.Order;
import tutorial.domain.model.OrderItem;

public interface OrderRepository {
    
    int getOrderId();
    
    int getOrderItemId();
    
    void addOrder(Order order);
    
    void addItem(OrderItem orderItem);
    
    Collection<Order> findOrdersByUserId(String userId);
    
    Collection<OrderItem> findOrderItemsByUserId(Order order);

}
