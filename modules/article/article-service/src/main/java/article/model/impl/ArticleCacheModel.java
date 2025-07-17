/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package article.model.impl;

import article.model.Article;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Article in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ArticleCacheModel implements CacheModel<Article>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ArticleCacheModel)) {
			return false;
		}

		ArticleCacheModel articleCacheModel = (ArticleCacheModel)object;

		if (articleId == articleCacheModel.articleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, articleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", articleId=");
		sb.append(articleId);
		sb.append(", titre=");
		sb.append(titre);
		sb.append(", detail=");
		sb.append(detail);
		sb.append(", dateCreation=");
		sb.append(dateCreation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Article toEntityModel() {
		ArticleImpl articleImpl = new ArticleImpl();

		if (uuid == null) {
			articleImpl.setUuid("");
		}
		else {
			articleImpl.setUuid(uuid);
		}

		articleImpl.setArticleId(articleId);

		if (titre == null) {
			articleImpl.setTitre("");
		}
		else {
			articleImpl.setTitre(titre);
		}

		if (detail == null) {
			articleImpl.setDetail("");
		}
		else {
			articleImpl.setDetail(detail);
		}

		if (dateCreation == Long.MIN_VALUE) {
			articleImpl.setDateCreation(null);
		}
		else {
			articleImpl.setDateCreation(new Date(dateCreation));
		}

		articleImpl.resetOriginalValues();

		return articleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		articleId = objectInput.readLong();
		titre = objectInput.readUTF();
		detail = objectInput.readUTF();
		dateCreation = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(articleId);

		if (titre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titre);
		}

		if (detail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(detail);
		}

		objectOutput.writeLong(dateCreation);
	}

	public String uuid;
	public long articleId;
	public String titre;
	public String detail;
	public long dateCreation;

}