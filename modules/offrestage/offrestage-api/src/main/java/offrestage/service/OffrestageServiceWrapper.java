/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OffrestageService}.
 *
 * @author Brian Wing Shun Chan
 * @see OffrestageService
 * @generated
 */
public class OffrestageServiceWrapper
	implements OffrestageService, ServiceWrapper<OffrestageService> {

	public OffrestageServiceWrapper() {
		this(null);
	}

	public OffrestageServiceWrapper(OffrestageService offrestageService) {
		_offrestageService = offrestageService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offrestageService.getOSGiServiceIdentifier();
	}

	@Override
	public OffrestageService getWrappedService() {
		return _offrestageService;
	}

	@Override
	public void setWrappedService(OffrestageService offrestageService) {
		_offrestageService = offrestageService;
	}

	private OffrestageService _offrestageService;

}