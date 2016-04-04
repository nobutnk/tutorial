package tutorial.app.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tutorial.domain.model.CartItem;

public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer cartId;
    
    List<CartItem> cartItems = new ArrayList<CartItem>();
    
    public Integer getCount() {
        return cartItems.size();
    }
    
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void addItem(CartItem item) {
        cartItems.add(item);
    }
    
    public void deleteItem(CartItem item) {
        cartItems.remove(item);
    }
    
    public void clearCart() {
        cartItems.clear();
    }

    /**
     * @return the cartId
     */
    public Integer getCartId() {
        return cartId;
    }

    /**
     * @param cartId the cartId to set
     */
    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}
