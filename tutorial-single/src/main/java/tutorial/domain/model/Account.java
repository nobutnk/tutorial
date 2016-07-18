package tutorial.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private boolean enabled;
    
    private boolean admin;
    
    private Date updatedAt;
    
    private Date createdAt;

}
