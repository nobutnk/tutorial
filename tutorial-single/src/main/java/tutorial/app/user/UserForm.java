package tutorial.app.user;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static interface UserFindOne {};

    @NotNull(groups = {UserFindOne.class})
    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private LocalDate birthday;
}
