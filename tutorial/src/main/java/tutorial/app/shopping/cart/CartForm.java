package tutorial.app.shopping.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<CartItemForm> cartItems = new ArrayList<CartItemForm>();

}
