package tutorial.app.common.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import tutorial.app.signup.SignupForm;

@Component
public class PasswordEqualsValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return SignupForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasFieldErrors("password")) {
            return;
        }

        SignupForm form = (SignupForm) target;
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();

        if (!password.equals(confirmPassword)) {
            errors.rejectValue(
                    "password",
                    "PasswordEqualsValidator.passwordResetForm.password",
                    "password and confirm password must be same.");
        }

    }

}
