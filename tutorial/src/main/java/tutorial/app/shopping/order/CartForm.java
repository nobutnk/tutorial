package tutorial.app.shopping.order;

import java.io.Serializable;

public class CartForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String itemId;

    /**
     * @return the itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}
