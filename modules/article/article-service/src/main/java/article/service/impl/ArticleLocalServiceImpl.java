/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package article.service.impl;

import article.model.Article;
import article.service.base.ArticleLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=article.model.Article",
	service = AopService.class
)
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {
	private static final Log _log = LogFactoryUtil.getLog(ArticleLocalServiceImpl.class);

	public Article addArticle(String titre,String detail) {
		try {
			long articleId = counterLocalService.increment(Article.class.getName());
			Article article = articlePersistence.create(articleId);
			article.setUuid(java.util.UUID.randomUUID().toString());
			article.setTitre(titre);
			article.setDetail(detail);
			article.setDateCreation(new Date());
			article = articlePersistence.update(article);

			_log.info("Article créé avec l'ID: " + articleId);

			return article;

		} catch (Exception e) {
			_log.error("Erreur lors de la création du article", e);
			throw new RuntimeException("Impossible de créer le article", e);
		}
	}
	public Article updateArticle(long articleId,String titre,String detail) throws PortalException {
		try {
			Article article = articlePersistence.findByPrimaryKey(articleId);
			if (article == null) {
				throw new PortalException("Contrat introuvable avec l'ID: " + articleId);
			}
			article.setTitre(titre);
			article.setDetail(detail);
			article = articlePersistence.update(article);
			_log.info("Article modifié avec l'ID: " + articleId);
			return article;
		} catch (Exception e) {
			_log.error("Erreur lors de la modification du article avec l'ID: " + articleId, e);
			throw new PortalException("Impossible de modifier le article avec l'ID: " + articleId, e);
		}
	}

	public Article getArticle(long articleId) throws PortalException {
		try {
			Article article = articlePersistence.findByPrimaryKey(articleId);

			_log.info("Article récupéré avec l'ID: " + articleId);

			return article;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération de l'article avec l'ID: " + articleId, e);
			throw new PortalException("Impossible de récupérer l'article avec l'ID: " + articleId, e);
		}
	}

	public java.util.List<Article> getAllArticles() {
		try {
			java.util.List<Article> articles = articlePersistence.findAll();

			_log.info("Tous les articles ont été récupérés. Total: " + articles.size());

			return articles;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération des articles", e);
			throw new RuntimeException("Impossible de récupérer la liste des articles", e);
		}
	}

	public java.util.List<Article> getArticles(int start, int end) {
		try {
			java.util.List<Article> articles = articlePersistence.findAll(start, end);

			_log.info("Articles récupérés de " + start + " à " + end + ". Total retourné: " + articles.size());

			return articles;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération des articles avec pagination", e);
			throw new RuntimeException("Impossible de récupérer la liste paginée des articles", e);
		}
	}

	public Article deleteArticle(long articleId) throws PortalException {
		try {
			Article article = articlePersistence.findByPrimaryKey(articleId);

			if (article == null) {
				throw new PortalException("Article introuvable avec l'ID: " + articleId);
			}

			article = articlePersistence.remove(article);

			_log.info("Article supprimé avec l'ID: " + articleId);

			return article;
		} catch (Exception e) {
			_log.error("Erreur lors de la suppression de l'article avec l'ID: " + articleId, e);
			throw new PortalException("Impossible de supprimer l'article avec l'ID: " + articleId, e);
		}
	}




}