package tutorial.app.shopping.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List<CartItemForm> cartItems = new ArrayList<CartItemForm>();

    /**
     * @return the cartItems
     */
    public List<CartItemForm> getCartItems() {
        return cartItems;
    }

    /**
     * @param cartItems the cartItems to set
     */
    public void setCartItems(List<CartItemForm> cartItems) {
        this.cartItems = cartItems;
    }

}
