package tutorial.domain.service.article;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import tutorial.domain.model.Article;
import tutorial.domain.repository.article.ArticleRepository;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    
    @Inject
    ArticleRepository articleRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Article findOne(String articleId) {
        Article article = articleRepository.findOne(articleId);
        if (article == null) {
            ResultMessages messages = ResultMessages.error();
            messages.add(ResultMessage
                    .fromText("[E404] The requested Article is not found. (id="
                            + articleId + ")"));
            throw new ResourceNotFoundException(messages);
        }
        return article;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Collection<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article create(Article article) {
        String articleId = UUID.randomUUID().toString();
        Date createdAt = new Date();

        article.setArticleId(articleId);
        article.setCreatedAt(createdAt);
        article.setUpdatedAt(createdAt);

        articleRepository.create(article);

        return article;
    }

    @Override
    public void delete(String articleId, Date updatedAt) {
        Article article = findOne(articleId);
        article.setUpdatedAt(updatedAt);
        int resultNum = articleRepository.delete(article);
        if (resultNum != 1) {
            ResultMessages messages = ResultMessages.error();
            messages.add(ResultMessage
                    .fromText("[E003] The requested Article is already updated. (id="
                            + article.getArticleId() + ")"));
            throw new BusinessException(messages);
        }
    }

}
