package tutorial.domain.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Article implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String articleId;
    
    private InputStream file;
    
    private String description;
    
    private String filename;
    
    private String contentType;
    
    private Date createdAt;
    
    private Date updatedAt;

}
