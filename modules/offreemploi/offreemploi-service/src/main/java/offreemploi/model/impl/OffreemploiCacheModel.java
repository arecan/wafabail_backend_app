/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import offreemploi.model.Offreemploi;

/**
 * The cache model class for representing Offreemploi in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OffreemploiCacheModel
	implements CacheModel<Offreemploi>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OffreemploiCacheModel)) {
			return false;
		}

		OffreemploiCacheModel offreemploiCacheModel =
			(OffreemploiCacheModel)object;

		if (OffreemploiId == offreemploiCacheModel.OffreemploiId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, OffreemploiId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", OffreemploiId=");
		sb.append(OffreemploiId);
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
	public Offreemploi toEntityModel() {
		OffreemploiImpl offreemploiImpl = new OffreemploiImpl();

		if (uuid == null) {
			offreemploiImpl.setUuid("");
		}
		else {
			offreemploiImpl.setUuid(uuid);
		}

		offreemploiImpl.setOffreemploiId(OffreemploiId);

		if (titre == null) {
			offreemploiImpl.setTitre("");
		}
		else {
			offreemploiImpl.setTitre(titre);
		}

		if (detail == null) {
			offreemploiImpl.setDetail("");
		}
		else {
			offreemploiImpl.setDetail(detail);
		}

		if (dateCreation == Long.MIN_VALUE) {
			offreemploiImpl.setDateCreation(null);
		}
		else {
			offreemploiImpl.setDateCreation(new Date(dateCreation));
		}

		offreemploiImpl.resetOriginalValues();

		return offreemploiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		OffreemploiId = objectInput.readLong();
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

		objectOutput.writeLong(OffreemploiId);

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
	public long OffreemploiId;
	public String titre;
	public String detail;
	public long dateCreation;

}