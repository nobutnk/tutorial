package tutorial.app.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tutorial.domain.model.CartItem;

public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    List<CartItem> cartItems = new ArrayList<CartItem>();
    
    public Integer getCount() {
        return cartItems.size();
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
}
