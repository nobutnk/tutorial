package tutorial.app.article;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.terasoluna.gfw.web.download.AbstractFileDownloadView;

import tutorial.domain.model.Article;

@Component
public class ArticleBinaryView extends AbstractFileDownloadView {

    @Override
    protected InputStream getInputStream(Map<String, Object> model, HttpServletRequest request) throws IOException {
        
        Article article = (Article) model.get("article");
        return article.getFile();
    }

    @Override
    protected void addResponseHeader(Map<String, Object> model, HttpServletRequest request,
            HttpServletResponse response) {
        
        Article article = (Article) model.get("article");
        response.setContentType(article.getContentType());
        response.setHeader("Content-Disposition",
                "attachment; filename=" + article.getFilename());
        
    }

    
    
}
