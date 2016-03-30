package tutorial.app.shopping;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tutorial.domain.model.Item;

public class Cart implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) {
        items.add(item);
    }
    
    public void clearCart() {
        items.clear();
    }
}
