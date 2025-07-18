package services;

import com.liferay.portal.kernel.exception.PortalException;
import dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    public ArticleDto getArticle(long articleId) throws PortalException;

    public List<ArticleDto> getAllArticles();

    public List<ArticleDto> getArticles(int start, int end);
}
