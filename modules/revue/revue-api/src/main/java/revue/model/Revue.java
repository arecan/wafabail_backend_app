/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Revue service. Represents a row in the &quot;WAFABAIL_Revue&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see RevueModel
 * @generated
 */
@ImplementationClassName("revue.model.impl.RevueImpl")
@ProviderType
public interface Revue extends PersistedModel, RevueModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>revue.model.impl.RevueImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Revue, Long> REVUE_ID_ACCESSOR =
		new Accessor<Revue, Long>() {

			@Override
			public Long get(Revue revue) {
				return revue.getRevueId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Revue> getTypeClass() {
				return Revue.class;
			}

		};

}