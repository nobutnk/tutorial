package tutorial.app.signup;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import tutorial.app.common.validator.annotation.BotDetectCaptcha;
import tutorial.app.common.validator.annotation.Jcaptcha;

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
    
    @Jcaptcha
    private String jcaptchaText;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPassword
     */
    public String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     * @param confirmPassword the confirmPassword to set
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * @return the jcaptchaText
     */
    public String getJcaptchaText() {
        return jcaptchaText;
    }

    /**
     * @param jcaptchaText the jcaptchaText to set
     */
    public void setJcaptchaText(String jcaptchaText) {
        this.jcaptchaText = jcaptchaText;
    }

    /**
     * @return the botDetectCaptchaText
     */
    public String getBotDetectCaptchaText() {
        return botDetectCaptchaText;
    }

    /**
     * @param botDetectCaptchaText the botDetectCaptchaText to set
     */
    public void setBotDetectCaptchaText(String botDetectCaptchaText) {
        this.botDetectCaptchaText = botDetectCaptchaText;
    }

}
