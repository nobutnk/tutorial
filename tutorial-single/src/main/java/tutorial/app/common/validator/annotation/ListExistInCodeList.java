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

import tutorial.app.common.validator.ListExistInCodeListValidatorForCharacter;
import tutorial.app.common.validator.ListExistInCodeListValidatorForString;

@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Constraint(validatedBy = { ListExistInCodeListValidatorForString.class,
        ListExistInCodeListValidatorForCharacter.class })
public @interface ListExistInCodeList {


    /**
     * Error message or message key
     * @return error message or message key
     */
    String message() default "{tutorial.app.common.validator.ListExistInCodeList.message}";

    /**
     * Bean ID of the codelist in which check the value<br>
     * @return bean ID of the codelist
     */
    String codeListId();

    /**
     * Constraint groups
     * @return constraint groups
     */
    Class<?>[] groups() default {};

    /**
     * Payload
     * @return payload
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several <code>@ListExistInCodeList</code> annotations on the same element
     * @see ListExistInCodeList
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        /**
         * <code>@ListExistInCodeList</code> annotations
         * @return annotations
         */
        ListExistInCodeList[] value();
    }
}
