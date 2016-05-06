package tutorial.domain.model;

import java.io.Serializable;

import org.joda.time.DateTime;

import lombok.Data;

@Data
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String todoId;

    private String todoTitle;
    
    private String todoCategory;
    
    private String todoDetail;
    
    private DateTime dueDate;
    
    private boolean publicTodo;

    private boolean finished;
    
    private DateTime updatedAt;

    private DateTime createdAt;

}
