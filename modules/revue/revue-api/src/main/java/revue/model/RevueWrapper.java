/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Revue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Revue
 * @generated
 */
public class RevueWrapper
	extends BaseModelWrapper<Revue> implements ModelWrapper<Revue>, Revue {

	public RevueWrapper(Revue revue) {
		super(revue);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("revueId", getRevueId());
		attributes.put("titre", getTitre());
		attributes.put("details", getDetails());
		attributes.put("lien", getLien());
		attributes.put("dateCreation", getDateCreation());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long revueId = (Long)attributes.get("revueId");

		if (revueId != null) {
			setRevueId(revueId);
		}

		String titre = (String)attributes.get("titre");

		if (titre != null) {
			setTitre(titre);
		}

		String details = (String)attributes.get("details");

		if (details != null) {
			setDetails(details);
		}

		String lien = (String)attributes.get("lien");

		if (lien != null) {
			setLien(lien);
		}

		Date dateCreation = (Date)attributes.get("dateCreation");

		if (dateCreation != null) {
			setDateCreation(dateCreation);
		}
	}

	@Override
	public Revue cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the date creation of this revue.
	 *
	 * @return the date creation of this revue
	 */
	@Override
	public Date getDateCreation() {
		return model.getDateCreation();
	}

	/**
	 * Returns the details of this revue.
	 *
	 * @return the details of this revue
	 */
	@Override
	public String getDetails() {
		return model.getDetails();
	}

	/**
	 * Returns the lien of this revue.
	 *
	 * @return the lien of this revue
	 */
	@Override
	public String getLien() {
		return model.getLien();
	}

	/**
	 * Returns the primary key of this revue.
	 *
	 * @return the primary key of this revue
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the revue ID of this revue.
	 *
	 * @return the revue ID of this revue
	 */
	@Override
	public long getRevueId() {
		return model.getRevueId();
	}

	/**
	 * Returns the titre of this revue.
	 *
	 * @return the titre of this revue
	 */
	@Override
	public String getTitre() {
		return model.getTitre();
	}

	/**
	 * Returns the uuid of this revue.
	 *
	 * @return the uuid of this revue
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
	 * Sets the date creation of this revue.
	 *
	 * @param dateCreation the date creation of this revue
	 */
	@Override
	public void setDateCreation(Date dateCreation) {
		model.setDateCreation(dateCreation);
	}

	/**
	 * Sets the details of this revue.
	 *
	 * @param details the details of this revue
	 */
	@Override
	public void setDetails(String details) {
		model.setDetails(details);
	}

	/**
	 * Sets the lien of this revue.
	 *
	 * @param lien the lien of this revue
	 */
	@Override
	public void setLien(String lien) {
		model.setLien(lien);
	}

	/**
	 * Sets the primary key of this revue.
	 *
	 * @param primaryKey the primary key of this revue
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the revue ID of this revue.
	 *
	 * @param revueId the revue ID of this revue
	 */
	@Override
	public void setRevueId(long revueId) {
		model.setRevueId(revueId);
	}

	/**
	 * Sets the titre of this revue.
	 *
	 * @param titre the titre of this revue
	 */
	@Override
	public void setTitre(String titre) {
		model.setTitre(titre);
	}

	/**
	 * Sets the uuid of this revue.
	 *
	 * @param uuid the uuid of this revue
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
	protected RevueWrapper wrap(Revue revue) {
		return new RevueWrapper(revue);
	}

}