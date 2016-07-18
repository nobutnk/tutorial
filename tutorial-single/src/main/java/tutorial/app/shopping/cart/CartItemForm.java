package tutorial.app.shopping.cart;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer itemId;

    private String itemCode;
    
    private Integer quantity;
    
    private Date updatedAt;
    
    private Date createdAt;

}
