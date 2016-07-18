package tutorial.domain.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer todoId;

    private String todoTitle;
    
    private String todoCategory;
    
    private String todoDetail;
    
    private LocalDate dueDate;
    
    private boolean publicTodo;

    private boolean finished;
    
    private LocalDateTime updatedAt;

    private LocalDateTime createdAt;

}
