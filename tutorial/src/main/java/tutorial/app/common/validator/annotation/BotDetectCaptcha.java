package tutorial.app.common.validator.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import tutorial.app.common.validator.BotDetectCaptchaValidator;

@Documented
@Constraint(validatedBy = { BotDetectCaptchaValidator.class })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface BotDetectCaptcha {
    
    String message() default "{tutorial.app.common.validator.BotDetect.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    /**
     * value in botDetect:captcha@id attribute.
     * @return captcha text name.
     */
    String imgTextName() default "botDetectCaptcha";
    
    /**
     * captcha verified attribute name in session.
     * @return captcha verified attribute name in session.
     */
    String verified() default "captchaVerified";

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        BotDetectCaptcha[] value();
    }

}
