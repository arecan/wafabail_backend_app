/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RevueService}.
 *
 * @author Brian Wing Shun Chan
 * @see RevueService
 * @generated
 */
public class RevueServiceWrapper
	implements RevueService, ServiceWrapper<RevueService> {

	public RevueServiceWrapper() {
		this(null);
	}

	public RevueServiceWrapper(RevueService revueService) {
		_revueService = revueService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _revueService.getOSGiServiceIdentifier();
	}

	@Override
	public RevueService getWrappedService() {
		return _revueService;
	}

	@Override
	public void setWrappedService(RevueService revueService) {
		_revueService = revueService;
	}

	private RevueService _revueService;

}