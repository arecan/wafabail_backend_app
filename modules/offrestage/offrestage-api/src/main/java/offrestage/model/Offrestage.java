/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Offrestage service. Represents a row in the &quot;WAFABAIL_Offrestage&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see OffrestageModel
 * @generated
 */
@ImplementationClassName("offrestage.model.impl.OffrestageImpl")
@ProviderType
public interface Offrestage extends OffrestageModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>offrestage.model.impl.OffrestageImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Offrestage, Long> STAGE_ID_ACCESSOR =
		new Accessor<Offrestage, Long>() {

			@Override
			public Long get(Offrestage offrestage) {
				return offrestage.getStageId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Offrestage> getTypeClass() {
				return Offrestage.class;
			}

		};

}