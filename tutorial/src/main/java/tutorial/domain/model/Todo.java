package tutorial.domain.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String todoId;

    private String todoTitle;
    
    private String todoCategory;
    
    private String todoDetail;
    
    private Date dueDate;

    private boolean finished;
    
    private Date updatedAt;

    private Date createdAt;

}
