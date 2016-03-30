package tutorial.domain.service.cart;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.app.shopping.Cart;
import tutorial.domain.model.CartItem;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Override
    public Cart addCartItem(Cart cart, CartItem cartItem) {
        return cart;
    }

}
