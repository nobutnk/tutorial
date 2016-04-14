package tutorial.app.signup;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import tutorial.app.common.validator.PasswordEqualsValidator;
import tutorial.domain.model.Account;
import tutorial.domain.service.auth.AccountUserService;

@Controller
@RequestMapping("/signup")
public class SingupController {
    
    @Inject
    Mapper beanMapper;
    
    @ModelAttribute
    public SignupForm setupForm() {
        return new SignupForm();
    }
    
    @Inject
    PasswordEqualsValidator passwordEqualsValidator;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(passwordEqualsValidator);
    }
    
    @Inject
    AccountUserService accountUserService;

    @RequestMapping(params = {"form"})
    public String signupForm(Model model) {
        return "signup/signupForm";
    }
    
    @RequestMapping(method = {RequestMethod.POST})
    public String login(
            @Validated SignupForm signupForm,
            BindingResult result,
            Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "signup/signupForm";
        }
        
        Account account = beanMapper.map(signupForm, Account.class);
        account.setUsername(signupForm.getEmail());
        
        try {
            accountUserService.create(account);
        } catch (BusinessException e) {
            model.addAttribute(e.getResultMessages());
            return signupForm(model);
        }
        
        attributes.addFlashAttribute(ResultMessages.success().add(
                ResultMessage.fromText("Account Created successfully!")));
        return "redirect:/login/loginForm";
    }
}
