package tutorial.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String itemId;

    private String itemName;
    
    private String itemCategory;
    
    private boolean finished;
    
    private Date updatedAt;
    
    private Date createdAt;

}
