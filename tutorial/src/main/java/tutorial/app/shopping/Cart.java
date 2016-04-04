package tutorial.app.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tutorial.domain.model.CartItem;

public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    
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
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }
}
