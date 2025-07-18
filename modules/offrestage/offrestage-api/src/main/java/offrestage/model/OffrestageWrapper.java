/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Offrestage}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Offrestage
 * @generated
 */
public class OffrestageWrapper
	extends BaseModelWrapper<Offrestage>
	implements ModelWrapper<Offrestage>, Offrestage {

	public OffrestageWrapper(Offrestage offrestage) {
		super(offrestage);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stageId", getStageId());
		attributes.put("titre", getTitre());
		attributes.put("detail", getDetail());
		attributes.put("dateCreation", getDateCreation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long stageId = (Long)attributes.get("stageId");

		if (stageId != null) {
			setStageId(stageId);
		}

		String titre = (String)attributes.get("titre");

		if (titre != null) {
			setTitre(titre);
		}

		String detail = (String)attributes.get("detail");

		if (detail != null) {
			setDetail(detail);
		}

		Date dateCreation = (Date)attributes.get("dateCreation");

		if (dateCreation != null) {
			setDateCreation(dateCreation);
		}
	}

	@Override
	public Offrestage cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the date creation of this offrestage.
	 *
	 * @return the date creation of this offrestage
	 */
	@Override
	public Date getDateCreation() {
		return model.getDateCreation();
	}

	/**
	 * Returns the detail of this offrestage.
	 *
	 * @return the detail of this offrestage
	 */
	@Override
	public String getDetail() {
		return model.getDetail();
	}

	/**
	 * Returns the primary key of this offrestage.
	 *
	 * @return the primary key of this offrestage
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stage ID of this offrestage.
	 *
	 * @return the stage ID of this offrestage
	 */
	@Override
	public long getStageId() {
		return model.getStageId();
	}

	/**
	 * Returns the titre of this offrestage.
	 *
	 * @return the titre of this offrestage
	 */
	@Override
	public String getTitre() {
		return model.getTitre();
	}

	/**
	 * Returns the uuid of this offrestage.
	 *
	 * @return the uuid of this offrestage
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the date creation of this offrestage.
	 *
	 * @param dateCreation the date creation of this offrestage
	 */
	@Override
	public void setDateCreation(Date dateCreation) {
		model.setDateCreation(dateCreation);
	}

	/**
	 * Sets the detail of this offrestage.
	 *
	 * @param detail the detail of this offrestage
	 */
	@Override
	public void setDetail(String detail) {
		model.setDetail(detail);
	}

	/**
	 * Sets the primary key of this offrestage.
	 *
	 * @param primaryKey the primary key of this offrestage
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stage ID of this offrestage.
	 *
	 * @param stageId the stage ID of this offrestage
	 */
	@Override
	public void setStageId(long stageId) {
		model.setStageId(stageId);
	}

	/**
	 * Sets the titre of this offrestage.
	 *
	 * @param titre the titre of this offrestage
	 */
	@Override
	public void setTitre(String titre) {
		model.setTitre(titre);
	}

	/**
	 * Sets the uuid of this offrestage.
	 *
	 * @param uuid the uuid of this offrestage
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected OffrestageWrapper wrap(Offrestage offrestage) {
		return new OffrestageWrapper(offrestage);
	}

}