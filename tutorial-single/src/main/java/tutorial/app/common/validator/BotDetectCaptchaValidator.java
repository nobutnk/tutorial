package tutorial.app.common.validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import botdetect.web.Captcha;
import tutorial.app.common.validator.annotation.BotDetectCaptcha;

public class BotDetectCaptchaValidator implements ConstraintValidator<BotDetectCaptcha, String> {

    private String imgTextName;
    private String verified;
    private String message;
    
    @Override
    public void initialize(BotDetectCaptcha constraintAnnotation) {
        imgTextName = constraintAnnotation.imgTextName();
        verified = constraintAnnotation.verified();
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
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute(verified) != null) {
            return true;
        }

        // validate the Captcha to check we're not dealing with a bot
        Captcha captcha = Captcha.load(request, imgTextName);
        boolean isHuman = captcha.validate(request, value);
        if (isHuman) {
            if (session == null) {
                session = request.getSession(true);
            }
            session.setAttribute(verified, true);
            return true;
        } else {
            return false;
        }
    }

}
