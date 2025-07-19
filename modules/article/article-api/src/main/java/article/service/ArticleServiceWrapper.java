/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package article.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ArticleService}.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleService
 * @generated
 */
public class ArticleServiceWrapper
	implements ArticleService, ServiceWrapper<ArticleService> {

	public ArticleServiceWrapper() {
		this(null);
	}

	public ArticleServiceWrapper(ArticleService articleService) {
		_articleService = articleService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _articleService.getOSGiServiceIdentifier();
	}

	@Override
	public ArticleService getWrappedService() {
		return _articleService;
	}

	@Override
	public void setWrappedService(ArticleService articleService) {
		_articleService = articleService;
	}

	private ArticleService _articleService;

}