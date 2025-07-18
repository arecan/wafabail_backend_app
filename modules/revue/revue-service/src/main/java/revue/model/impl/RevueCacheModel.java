/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import revue.model.Revue;

/**
 * The cache model class for representing Revue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RevueCacheModel implements CacheModel<Revue>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RevueCacheModel)) {
			return false;
		}

		RevueCacheModel revueCacheModel = (RevueCacheModel)object;

		if (revueId == revueCacheModel.revueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, revueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", revueId=");
		sb.append(revueId);
		sb.append(", titre=");
		sb.append(titre);
		sb.append(", details=");
		sb.append(details);
		sb.append(", lien=");
		sb.append(lien);
		sb.append(", dateCreation=");
		sb.append(dateCreation);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Revue toEntityModel() {
		RevueImpl revueImpl = new RevueImpl();

		if (uuid == null) {
			revueImpl.setUuid("");
		}
		else {
			revueImpl.setUuid(uuid);
		}

		revueImpl.setRevueId(revueId);

		if (titre == null) {
			revueImpl.setTitre("");
		}
		else {
			revueImpl.setTitre(titre);
		}

		if (details == null) {
			revueImpl.setDetails("");
		}
		else {
			revueImpl.setDetails(details);
		}

		if (lien == null) {
			revueImpl.setLien("");
		}
		else {
			revueImpl.setLien(lien);
		}

		if (dateCreation == Long.MIN_VALUE) {
			revueImpl.setDateCreation(null);
		}
		else {
			revueImpl.setDateCreation(new Date(dateCreation));
		}

		revueImpl.resetOriginalValues();

		return revueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		revueId = objectInput.readLong();
		titre = objectInput.readUTF();
		details = objectInput.readUTF();
		lien = objectInput.readUTF();
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

		objectOutput.writeLong(revueId);

		if (titre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(titre);
		}

		if (details == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(details);
		}

		if (lien == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lien);
		}

		objectOutput.writeLong(dateCreation);
	}

	public String uuid;
	public long revueId;
	public String titre;
	public String details;
	public String lien;
	public long dateCreation;

}