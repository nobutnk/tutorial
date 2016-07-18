package tutorial.app.user;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import tutorial.domain.model.User;
import tutorial.domain.service.user.UserService;

@Controller
@RequestMapping("user")
public class UserController {
    
    @Inject
    Mapper beanMapper;
    
    @Inject
    UserService userService;

    @ModelAttribute
    public UserForm setUpForm() {
        UserForm form = new UserForm();
        return form;
    }

    @RequestMapping(value = "find")
    public String find(@Validated UserForm userForm,
            BindingResult bindingResult,Model model) {
        
        
        User user = userService.findOne(userForm.getId());
        model.addAttribute("user", user);
        return "user/user";
    }

}
