package tutorial.app.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import tutorial.domain.model.CartItem;

@Setter
@Getter
public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer cartId;
    
    private String userId = "00000001";
    
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

}
