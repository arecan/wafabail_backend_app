/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import offrestage.model.Offrestage;

/**
 * The cache model class for representing Offrestage in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class OffrestageCacheModel
	implements CacheModel<Offrestage>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof OffrestageCacheModel)) {
			return false;
		}

		OffrestageCacheModel offrestageCacheModel =
			(OffrestageCacheModel)object;

		if (stageId == offrestageCacheModel.stageId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stageId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stageId=");
		sb.append(stageId);
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
	public Offrestage toEntityModel() {
		OffrestageImpl offrestageImpl = new OffrestageImpl();

		if (uuid == null) {
			offrestageImpl.setUuid("");
		}
		else {
			offrestageImpl.setUuid(uuid);
		}

		offrestageImpl.setStageId(stageId);

		if (titre == null) {
			offrestageImpl.setTitre("");
		}
		else {
			offrestageImpl.setTitre(titre);
		}

		if (detail == null) {
			offrestageImpl.setDetail("");
		}
		else {
			offrestageImpl.setDetail(detail);
		}

		if (dateCreation == Long.MIN_VALUE) {
			offrestageImpl.setDateCreation(null);
		}
		else {
			offrestageImpl.setDateCreation(new Date(dateCreation));
		}

		offrestageImpl.resetOriginalValues();

		return offrestageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		stageId = objectInput.readLong();
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

		objectOutput.writeLong(stageId);

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
	public long stageId;
	public String titre;
	public String detail;
	public long dateCreation;

}