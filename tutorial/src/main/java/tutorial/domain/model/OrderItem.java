package tutorial.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String userId;
    
    private Integer orderId;
    
    private Integer itemId;
    
    private String itemCode;
    
    private Integer quantity;
    
    private Date updatedAt;
    
    private Date createdAt;

}
