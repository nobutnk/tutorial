package tutorial.domain.repository.cart;

import java.util.Collection;

import tutorial.domain.model.CartItem;

public interface CartRepository {

    Collection<CartItem> findAll(String userId);
    
    int getCartId();
    
    int getCartItemId();
    
    void addItem(CartItem cartItem);
    
    int updateItem(CartItem cartItem);
    
    int deleteItem(CartItem cartItem);
}
