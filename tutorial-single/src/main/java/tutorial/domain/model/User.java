package tutorial.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private LocalDate birthday;
    
    private LocalDateTime createdAt;
    
    private LocalDateTime updatedAt;

}
