package tutorial.app.shopping.item;

import java.io.Serializable;

public class ItemForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String itemCode;
    
    private Integer quantity;

    /**
     * @return the itemCode
     */
    public String getItemCode() {
        return itemCode;
    }

    /**
     * @param itemCode the itemCode to set
     */
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
