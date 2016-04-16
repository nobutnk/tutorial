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

    @Override
    public void initialize(BotDetectCaptcha constraintAnnotation) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attr.getRequest();

        if (value == null) {
            return true;
        }
        return isCaptchaValid(request, value);
    }

    static boolean isCaptchaValid(HttpServletRequest request, String value) {
        HttpSession session = request.getSession(false);

        if (session != null && session.getAttribute("captchaVerified") != null) {
            return true;
        }

        // validate the Captcha to check we're not dealing with a bot
        Captcha captcha = Captcha.load(request, "springFormCaptcha");
        boolean isHuman = captcha.validate(request, value);
        if (isHuman) {
            if (session == null) {
                session = request.getSession(true);
            }
            session.setAttribute("captchaVerified", true);
            return true;
        } else {
            return false;
        }
    }

}
