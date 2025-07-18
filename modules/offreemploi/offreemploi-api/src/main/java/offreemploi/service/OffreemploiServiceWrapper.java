/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OffreemploiService}.
 *
 * @author Brian Wing Shun Chan
 * @see OffreemploiService
 * @generated
 */
public class OffreemploiServiceWrapper
	implements OffreemploiService, ServiceWrapper<OffreemploiService> {

	public OffreemploiServiceWrapper() {
		this(null);
	}

	public OffreemploiServiceWrapper(OffreemploiService offreemploiService) {
		_offreemploiService = offreemploiService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offreemploiService.getOSGiServiceIdentifier();
	}

	@Override
	public OffreemploiService getWrappedService() {
		return _offreemploiService;
	}

	@Override
	public void setWrappedService(OffreemploiService offreemploiService) {
		_offreemploiService = offreemploiService;
	}

	private OffreemploiService _offreemploiService;

}