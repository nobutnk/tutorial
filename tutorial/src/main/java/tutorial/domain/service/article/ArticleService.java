package tutorial.domain.service.article;

import java.util.Collection;
import java.util.Date;

import tutorial.domain.model.Article;

public interface ArticleService {

    Collection<Article> findAll();
    
    Article findOne(String articleId);

    Article create(Article article);

    void delete(String articleId, Date updatedAt);
}
