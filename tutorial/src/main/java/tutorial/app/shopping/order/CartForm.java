package tutorial.app.shopping.order;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CartForm implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    public static interface CartAdd {}
    public static interface CartDelete {}
    
    @NotNull( groups = {CartAdd.class, CartDelete.class})
    private String userId;
    
    @NotNull( groups = {CartAdd.class, CartDelete.class})
    private String itemId;
    
    @NotNull( groups = {CartDelete.class})
    private String userItemId;

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

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

}
