package tutorial.app.signup;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import tutorial.app.common.validator.annotation.BotDetectCaptcha;

@Setter
@Getter
public class SignupForm implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotNull
    private String email;
    
    @NotNull
    @Size(min = 8)
    private String password;
    
    @NotNull
    private String confirmPassword;
    
    @BotDetectCaptcha
    private String botDetectCaptchaText;

}
