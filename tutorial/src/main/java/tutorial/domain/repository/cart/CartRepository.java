package tutorial.domain.repository.cart;

import java.util.Collection;

import tutorial.domain.model.CartItem;

public interface CartRepository {

    Collection<CartItem> findAll(String userId);
    
    void addItem(CartItem cartItem);
    
    int updateItem(CartItem cartItem);
    
    int deleteItem(CartItem cartItem);
}
