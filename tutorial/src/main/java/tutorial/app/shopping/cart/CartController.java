package tutorial.app.shopping.cart;

import java.util.Iterator;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tutorial.app.shopping.Cart;
import tutorial.app.shopping.SessionCart;
import tutorial.domain.model.CartItem;
import tutorial.domain.service.cart.CartService;

@Controller
@RequestMapping("cart")
public class CartController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(CartController.class);
    
    @Inject
    Mapper beanMapper;
    
    @Inject
    CartService cartService;
    
    @Inject
    SessionCart sessionCart;
    
    @ModelAttribute
    public CartForm setUpCartForm() {
        return new CartForm();
    }

    @RequestMapping
    public String cart(CartForm form) {
        beanMapper.map(sessionCart.getCart(), form);
        return "cart/cart";
    }

    public String edit(@Validated CartForm form, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "cart/cart";
        }

        Cart cart = sessionCart.getCart();
        Iterator<CartItemForm> itemForm = form.getCartItems().iterator();
        for (CartItem item : cart.getCartItems()) {
            beanMapper.map(itemForm.next(), item);
        }

        cart = cartService.saveCart(cart);
        sessionCart.setCart(cart);

        return "redirect:/cart";
    }
}
