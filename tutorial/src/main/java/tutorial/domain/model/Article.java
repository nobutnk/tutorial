package tutorial.domain.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String articleId;
    
    private InputStream file;
    
    private String description;
    
    private String filename;
    
    private String contentType;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    /**
     * @return the articleId
     */
    public String getArticleId() {
        return articleId;
    }
    /**
     * @param articleId the articleId to set
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }
    /**
     * @return the file
     */
    public InputStream getFile() {
        return file;
    }
    /**
     * @param file the file to set
     */
    public void setFile(InputStream file) {
        this.file = file;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
    /**
     * @return the contentType
     */
    public String getContentType() {
        return contentType;
    }
    /**
     * @param contentType the contentType to set
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    /**
     * @return the filename
     */
    public String getFilename() {
        return filename;
    }
    /**
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

}
