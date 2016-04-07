package tutorial.app.shopping.order;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tutorial.app.shopping.Cart;
import tutorial.app.shopping.SessionCart;
import tutorial.domain.model.Order;
import tutorial.domain.service.order.OrderService;

@Controller
@RequestMapping("order")
public class OrderController {
    
    @Inject
    OrderService orderService;
    
    @Inject
    SessionCart sessionCart;

    @ModelAttribute
    public OrderForm setUpOrderForm() {
        return new OrderForm();
    }

    @RequestMapping
    public String view() {
        return "order/order";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String order(
            @Validated OrderForm form, BindingResult result,
            Model model, RedirectAttributes attributes) {
        
        if (result.hasErrors()) {
            return "cart/cart";
        }
        
        Cart cart = sessionCart.getCart();
        Order order = orderService.saveOrder(cart);
        
        attributes.addFlashAttribute(order);
        return "redirect:/order?complete";
    }

    @RequestMapping(params = "complete", method = RequestMethod.GET)
    public String complete(Model model, SessionStatus sessionStatus) {
        sessionCart.clearCart();
        return "order/complete";
    }

}
