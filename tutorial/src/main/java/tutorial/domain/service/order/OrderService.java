package tutorial.domain.service.order;

import java.util.Collection;

import tutorial.app.shopping.Cart;
import tutorial.domain.model.Order;
import tutorial.domain.model.OrderItem;

public interface OrderService {

    Order saveOrder(Cart cart);
    
    Collection<Order> findOrderByUserId(String userId);
    
    Collection<OrderItem> findOrderItemByUserId(Integer orderId, String userId);
}
