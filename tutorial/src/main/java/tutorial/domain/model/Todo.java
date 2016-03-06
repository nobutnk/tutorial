package tutorial.domain.model;

import java.io.Serializable;
import java.util.Date;

public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String todoId;

    private String todoTitle;
    
    private String todoDetail;

    private boolean finished;
    
    private Date updatedAt;

    private Date createdAt;

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

    /**
     * @return the todoTitle
     */
    public String getTodoTitle() {
        return todoTitle;
    }

    /**
     * @param todoTitle the todoTitle to set
     */
    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
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
