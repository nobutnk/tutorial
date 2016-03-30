package tutorial.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Item implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private String itemId;

    private String itemName;
    
    private String itemCategory;
    
    private boolean finished;
    
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
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return the itemCategory
     */
    public String getItemCategory() {
        return itemCategory;
    }

    /**
     * @param itemCategory the itemCategory to set
     */
    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    /**
     * @return the finished
     */
    public boolean isFinished() {
        return finished;
    }

    /**
     * @param finished the finished to set
     */
    public void setFinished(boolean finished) {
        this.finished = finished;
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
