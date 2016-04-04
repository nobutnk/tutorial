package tutorial.domain.service.cart;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.app.shopping.Cart;
import tutorial.domain.model.CartItem;
import tutorial.domain.repository.cart.CartRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    
    @Inject
    CartRepository cartRepository;

    @Override
    public Cart addCartItem(Cart cart, CartItem cartItem) {
        
//        Date createdAt = new Date();
//        
//        cartItem.setCreatedAt(createdAt);
//        cartItem.setUpdatedAt(createdAt);
//        
//        cartRepository.addItem(cartItem);
        cart.addItem(cartItem);
        
        return cart;
    }
    
    @Override
    public Cart deleteCartItem(Cart cart, CartItem cartItem) {
        
        cartRepository.deleteItem(cartItem);
        cart.addItem(cartItem);
        
        return cart;
    }

    @Override
    public Cart saveCart(Cart cart) {
        // TODO Auto-generated method stub
        return cart;
    }

}
