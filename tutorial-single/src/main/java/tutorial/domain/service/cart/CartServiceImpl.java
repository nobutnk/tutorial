package tutorial.domain.service.cart;

import javax.inject.Inject;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.app.auth.AccountUserDetails;
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
        
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        String userId = null;
        if (authentication.getPrincipal() instanceof AccountUserDetails) {
            AccountUserDetails userDetails =
                    AccountUserDetails.class.cast(authentication.getPrincipal());
            userId = userDetails.getAccount().getId().toString();
        }
        
        cart.setUserId(userId);
        
        int cartId;
        if (cart.getCartId() == null) {
            cartId = cartRepository.getCartId();
            cartItem.setCartId(cartId);
            cartItem.setUserId(cart.getUserId());
            cartRepository.addCart(cartItem);
            cart.setCartId(cartId);
        }
        
        int cartItemId = cartRepository.getCartItemId();
        cartItem.setItemId(cartItemId);
        
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
