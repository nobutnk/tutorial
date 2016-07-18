package tutorial.app.article;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import tutorial.app.common.validator.annotation.UploadFileMaxSize;
import tutorial.app.common.validator.annotation.UploadFileNotEmpty;
import tutorial.app.common.validator.annotation.UploadFileRequired;

@Setter
@Getter
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

}
