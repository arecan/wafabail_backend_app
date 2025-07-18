/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Offreemploi service. Represents a row in the &quot;WAFABAIL_Offreemploi&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OffreemploiModel
 * @generated
 */
@ImplementationClassName("offreemploi.model.impl.OffreemploiImpl")
@ProviderType
public interface Offreemploi extends OffreemploiModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>offreemploi.model.impl.OffreemploiImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Offreemploi, Long> OFFREEMPLOI_ID_ACCESSOR =
		new Accessor<Offreemploi, Long>() {

			@Override
			public Long get(Offreemploi offreemploi) {
				return offreemploi.getOffreemploiId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Offreemploi> getTypeClass() {
				return Offreemploi.class;
			}

		};

}