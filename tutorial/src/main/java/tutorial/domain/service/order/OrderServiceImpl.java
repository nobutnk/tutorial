package tutorial.domain.service.order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.app.auth.AccountUserDetails;
import tutorial.app.shopping.Cart;
import tutorial.domain.model.CartItem;
import tutorial.domain.model.Order;
import tutorial.domain.model.OrderItem;
import tutorial.domain.repository.order.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    
    @Inject
    OrderRepository orderRepository;
    
    @Inject
    Mapper beanMapper;

    @Override
    public Order saveOrder(Cart cart) {
        
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String userId = null;
        if (authentication.getPrincipal() instanceof AccountUserDetails) {
            AccountUserDetails userDetails =
                    AccountUserDetails.class.cast(authentication.getPrincipal());
            userId = userDetails.getAccount().getId().toString();
        }
        
        int orderId = orderRepository.getOrderId();
        Date createdAt = new Date();
        
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setCreatedAt(createdAt);
        order.setUpdatedAt(createdAt);
        
        orderRepository.addOrder(order);
        
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (CartItem item : cart.getCartItems()) {
            OrderItem orderItem = new OrderItem();
            beanMapper.map(item, orderItem);
            orderItem.setOrderId(orderId);
            orderItem.setUserId("00000001");
            orderItems.add(orderItem);
            
            orderRepository.addItem(orderItem);
        }
        
        order.setOrdetItems(orderItems);
        
        return order;
    }

    @Override
    public Collection<Order> findOrderByUserId(String userId) {
        return orderRepository.findOrdersByUserId(userId);
    }

    @Override
    public Collection<OrderItem> findOrderItemByUserId(Integer orderId, String userId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        
        return orderRepository.findOrderItemsByUserId(order);
    }

}
