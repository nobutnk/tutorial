package tutorial.app.shopping.item;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String itemCode;
    
    private Integer quantity;

}
