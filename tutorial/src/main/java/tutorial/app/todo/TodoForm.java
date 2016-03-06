package tutorial.app.todo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TodoForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 1, max = 30)
    private String todoTitle;
    
    @NotNull
    @Size(min = 1, max = 100)
    private String todoDetail;
    
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
}
