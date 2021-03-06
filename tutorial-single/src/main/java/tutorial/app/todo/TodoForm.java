package tutorial.app.todo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.terasoluna.gfw.common.codelist.ExistInCodeList;

import lombok.Getter;
import lombok.Setter;
import tutorial.app.common.validator.annotation.ListExistInCodeList;

@Setter
@Getter
public class TodoForm implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static interface TodoCreate {
    };

    public static interface TodoFinish {
    };
    
    public static interface TodoUpdate {
    };
    
    public static interface TodoUpdateForm {
    };

    public static interface TodoDelete {
    };
    
    @NotNull(groups = { TodoFinish.class, TodoUpdate.class, TodoUpdateForm.class, TodoDelete.class })
    private Integer todoId;

    @NotNull(groups = { TodoCreate.class, TodoUpdate.class })
    @Size(min = 1, max = 30, groups = { TodoFinish.class, TodoUpdate.class })
    private String todoTitle;
    
    @NotNull(groups = { TodoCreate.class, TodoUpdate.class })
    @ExistInCodeList(codeListId = "CL_TODO_CATEGORIES", groups = { TodoCreate.class, TodoUpdate.class })
    private String todoCategory;
    
    @NotNull(groups = { TodoCreate.class, TodoUpdate.class })
    @ListExistInCodeList(codeListId = "CL_PARTIES", groups = { TodoCreate.class, TodoUpdate.class })
    private List<String> parties;
    
    @NotNull(groups = { TodoCreate.class, TodoUpdate.class })
    @Size(min = 1, max = 100, groups = { TodoFinish.class, TodoUpdate.class })
    private String todoDetail;
    
    @NotNull(groups = { TodoCreate.class, TodoUpdate.class })
    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate dueDate;
    
    @NotNull(groups = { TodoFinish.class, TodoUpdate.class, TodoDelete.class })
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime updatedAt;
    
    @NotNull(groups = { TodoCreate.class, TodoUpdate.class })
    private Boolean publicTodo;
}
