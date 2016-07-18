package tutorial.domain.repository.article;

import java.util.Collection;

import tutorial.domain.model.Article;

public interface ArticleRepository {

    Article findOne(String articleId);

    Collection<Article> findAll();

    void create(Article article);

    int delete(Article article);
}
