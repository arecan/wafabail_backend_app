/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package article.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Article}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @generated
 */
public class ArticleWrapper
	extends BaseModelWrapper<Article>
	implements Article, ModelWrapper<Article> {

	public ArticleWrapper(Article article) {
		super(article);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("articleId", getArticleId());
		attributes.put("titre", getTitre());
		attributes.put("detail", getDetail());
		attributes.put("dateCreation", getDateCreation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long articleId = (Long)attributes.get("articleId");

		if (articleId != null) {
			setArticleId(articleId);
		}

		String titre = (String)attributes.get("titre");

		if (titre != null) {
			setTitre(titre);
		}

		String detail = (String)attributes.get("detail");

		if (detail != null) {
			setDetail(detail);
		}

		Date dateCreation = (Date)attributes.get("dateCreation");

		if (dateCreation != null) {
			setDateCreation(dateCreation);
		}
	}

	@Override
	public Article cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the article ID of this article.
	 *
	 * @return the article ID of this article
	 */
	@Override
	public long getArticleId() {
		return model.getArticleId();
	}

	/**
	 * Returns the date creation of this article.
	 *
	 * @return the date creation of this article
	 */
	@Override
	public Date getDateCreation() {
		return model.getDateCreation();
	}

	/**
	 * Returns the detail of this article.
	 *
	 * @return the detail of this article
	 */
	@Override
	public String getDetail() {
		return model.getDetail();
	}

	/**
	 * Returns the primary key of this article.
	 *
	 * @return the primary key of this article
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the titre of this article.
	 *
	 * @return the titre of this article
	 */
	@Override
	public String getTitre() {
		return model.getTitre();
	}

	/**
	 * Returns the uuid of this article.
	 *
	 * @return the uuid of this article
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the article ID of this article.
	 *
	 * @param articleId the article ID of this article
	 */
	@Override
	public void setArticleId(long articleId) {
		model.setArticleId(articleId);
	}

	/**
	 * Sets the date creation of this article.
	 *
	 * @param dateCreation the date creation of this article
	 */
	@Override
	public void setDateCreation(Date dateCreation) {
		model.setDateCreation(dateCreation);
	}

	/**
	 * Sets the detail of this article.
	 *
	 * @param detail the detail of this article
	 */
	@Override
	public void setDetail(String detail) {
		model.setDetail(detail);
	}

	/**
	 * Sets the primary key of this article.
	 *
	 * @param primaryKey the primary key of this article
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the titre of this article.
	 *
	 * @param titre the titre of this article
	 */
	@Override
	public void setTitre(String titre) {
		model.setTitre(titre);
	}

	/**
	 * Sets the uuid of this article.
	 *
	 * @param uuid the uuid of this article
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ArticleWrapper wrap(Article article) {
		return new ArticleWrapper(article);
	}

}