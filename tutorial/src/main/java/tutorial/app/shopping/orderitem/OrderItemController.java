package tutorial.app.shopping.orderitem;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import tutorial.app.shopping.Cart;
import tutorial.app.shopping.SessionCart;
import tutorial.app.shopping.orderitem.OrderItemForm.OrderItemAdd;
import tutorial.domain.model.Item;
import tutorial.domain.service.oderitem.OrderItemService;

@Controller
@RequestMapping("orderitem")
public class OrderItemController {

    @Inject
    Mapper beanMapper;
    
    @Inject
    OrderItemService orderItemService;
    
    @Inject
    SessionCart sessionCart;
    
    @ModelAttribute
    public OrderItemForm setUpForm() {
        OrderItemForm form = new OrderItemForm();
        return form;
    }
    
    @RequestMapping(value = "list")
    public String list(Model model) {
        Collection<Item> items = orderItemService.findAll();
        model.addAttribute("items", items);
        return "orderitem/list";
    }
    
}
