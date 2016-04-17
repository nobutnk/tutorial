package tutorial.app.common.validator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;

import tutorial.app.common.validator.annotation.Jcaptcha;

public class JcaptchaValidator implements ConstraintValidator<Jcaptcha, String> {

    private String message;
    
    @Override
    public void initialize(Jcaptcha constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();

        if (value == null) {
            return true;
        }
        
        boolean matched = isCaptchaValid(request, value);
        if (matched) {
            return true;
        } else {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message)
                    .addConstraintViolation();
            
            return false;
        }
    }

    public boolean isCaptchaValid(HttpServletRequest request, String value) {
        boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, value);
        if (captchaPassed) {
            return true;
        } else {
            return false;
        }
    }

}
