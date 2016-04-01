package tutorial.domain.model;

import java.io.Serializable;
import java.util.Date;

public class CartItem implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String userId;
    
    private String itemId;
    
    private Integer userItemId;
    
    private Date updatedAt;
    
    private Date createdAt;

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

    /**
     * @return the userItemId
     */
    public Integer getUserItemId() {
        return userItemId;
    }

    /**
     * @param userItemId the userItemId to set
     */
    public void setUserItemId(Integer userItemId) {
        this.userItemId = userItemId;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
