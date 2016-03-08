package tutorial.app.todo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private String todoId;

    @NotNull(groups = { TodoFinish.class, TodoUpdate.class })
    @Size(min = 1, max = 30, groups = { TodoFinish.class, TodoUpdate.class })
    private String todoTitle;
    
    @NotNull(groups = { TodoFinish.class, TodoUpdate.class })
    @Size(min = 1, max = 100, groups = { TodoFinish.class, TodoUpdate.class })
    private String todoDetail;
    
    @NotNull(groups = { TodoFinish.class, TodoUpdate.class, TodoDelete.class })
    private String updatedAt;

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    /**
     * @return the todoDetail
     */
    public String getTodoDetail() {
        return todoDetail;
    }

    /**
     * @param todoDetail the todoDetail to set
     */
    public void setTodoDetail(String todoDetail) {
        this.todoDetail = todoDetail;
    }

    /**
     * @return the updatedAt
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the todoId
     */
    public String getTodoId() {
        return todoId;
    }

    /**
     * @param todoId the todoId to set
     */
    public void setTodoId(String todoId) {
        this.todoId = todoId;
    }
}
