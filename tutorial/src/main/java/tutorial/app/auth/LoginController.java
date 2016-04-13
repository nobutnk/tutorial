package tutorial.app.auth;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    
    @ModelAttribute
    public LoginForm setupForm() {
        return new LoginForm();
    }

    @RequestMapping(value = "loginForm")
    public String index() {
        return "login/loginForm";
    }
    
    @RequestMapping
    public String login(@Validated LoginForm form, BindingResult result) {
        if (result.hasErrors()) {
            return index();
        }
        return "forward:/authenticate";
    }
}
