package tutorial.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
    
    public void setOrdetItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
