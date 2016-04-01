package tutorial.domain.service.cart;

import tutorial.app.shopping.Cart;
import tutorial.domain.model.CartItem;

public interface CartService {

    Cart addCartItem(Cart cart, CartItem cartItem);
    
    Cart deleteCartItem(Cart cart, CartItem cartItem);
}
