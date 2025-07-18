package services.impl;

import article.model.Article;
import article.service.ArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import dto.ArticleDto;
import services.ArticleService;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component(
        service = {ArticleServiceImpl.class, ArticleService.class }
)

public class ArticleServiceImpl implements ArticleService {
    private ArticleDto toDto(Article article) {
        if (article == null) return null;
        return new ArticleDto(
                article.getArticleId(),
                article.getTitre(),
                article.getDetail(),
                article.getDateCreation()
        );
    }

    private List<ArticleDto> toDtoList(List<Article> articles) {
        return articles.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ArticleDto getArticle(long articleId) throws PortalException {
        return toDto(ArticleLocalServiceUtil.getArticle(articleId));
    }

    @Override
    public List<ArticleDto> getAllArticles() {
        return toDtoList(ArticleLocalServiceUtil.getAllArticles());
    }

    @Override
    public List<ArticleDto> getArticles(int start, int end) {
        return toDtoList(ArticleLocalServiceUtil.getArticles(start, end));
    }
}
