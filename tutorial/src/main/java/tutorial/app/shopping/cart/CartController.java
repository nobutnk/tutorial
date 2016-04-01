package tutorial.app.shopping.cart;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tutorial.app.shopping.Cart;
import tutorial.app.shopping.SessionCart;
import tutorial.app.shopping.order.CartForm;
import tutorial.app.shopping.order.CartForm.CartAdd;
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

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(
            @Validated({ Default.class, CartAdd.class }) CartForm cartForm,
            BindingResult bindingResult,
            Model model, RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return "/orderitem/list";
        }

        CartItem cartItem = beanMapper.map(cartForm, CartItem.class);
        Cart addedCart = cartService.addCartItem(sessionCart.getCart(),
                cartItem);
        
        logger.debug("number of item in your cart = " + addedCart.getCount());
        sessionCart.setCart(addedCart);
        return "redirect:/orderitem/list";
    }
}
