package tutorial.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer orderId;
    
    private String userId;
    
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
    
    private Date createdAt;
    
    private Date updatedAt;
    public Integer getCount() {
        return orderItems.size();
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void setOrdetItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    /**
     * @return the orderId
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

}
