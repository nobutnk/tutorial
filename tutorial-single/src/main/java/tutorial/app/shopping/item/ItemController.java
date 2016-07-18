package tutorial.app.shopping.item;

import javax.inject.Inject;

import org.dozer.Mapper;
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
@RequestMapping("item")
public class ItemController {
    
    @Inject
    SessionCart sessionCart;

    @Inject
    CartService cartService;

    @Inject
    Mapper beanMapper;

    @ModelAttribute
    public ItemForm setUpItemForm() {
        return new ItemForm();
    }

    @RequestMapping
    public String view(Model model) {
        return "item/item";
    }

    @RequestMapping(value = "add")
    public String addCart(@Validated ItemForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "item/item";
        }
        CartItem cartItem = beanMapper.map(form, CartItem.class);
        Cart cart = cartService.addCartItem(
                sessionCart.getCart(),
                cartItem);
        sessionCart.setCart(cart);
        return "redirect:/cart";
    }

}
