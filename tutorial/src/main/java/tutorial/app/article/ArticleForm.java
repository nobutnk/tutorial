package tutorial.app.article;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import tutorial.app.common.validator.annotation.UploadFileMaxSize;
import tutorial.app.common.validator.annotation.UploadFileNotEmpty;
import tutorial.app.common.validator.annotation.UploadFileRequired;

public class ArticleForm implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public static interface ArticleDelete {
    };
    
    public static interface ArticleDownload {
    };
    
    public static interface ArticleCreate {
    };
    
    @NotNull(groups = { ArticleDownload.class, ArticleDelete.class })
    private String articleId;

    @UploadFileRequired(groups = { ArticleCreate.class })
    @UploadFileNotEmpty(groups = { ArticleCreate.class })
    @UploadFileMaxSize(groups = { ArticleCreate.class })
    private MultipartFile file;

    @NotNull(groups = { ArticleCreate.class })
    @Size(min = 0, max = 100, groups = { ArticleCreate.class })
    private String description;

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
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
}
