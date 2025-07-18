/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Offreemploi}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Offreemploi
 * @generated
 */
public class OffreemploiWrapper
	extends BaseModelWrapper<Offreemploi>
	implements ModelWrapper<Offreemploi>, Offreemploi {

	public OffreemploiWrapper(Offreemploi offreemploi) {
		super(offreemploi);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("OffreemploiId", getOffreemploiId());
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

		Long OffreemploiId = (Long)attributes.get("OffreemploiId");

		if (OffreemploiId != null) {
			setOffreemploiId(OffreemploiId);
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
	public Offreemploi cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the date creation of this offreemploi.
	 *
	 * @return the date creation of this offreemploi
	 */
	@Override
	public Date getDateCreation() {
		return model.getDateCreation();
	}

	/**
	 * Returns the detail of this offreemploi.
	 *
	 * @return the detail of this offreemploi
	 */
	@Override
	public String getDetail() {
		return model.getDetail();
	}

	/**
	 * Returns the offreemploi ID of this offreemploi.
	 *
	 * @return the offreemploi ID of this offreemploi
	 */
	@Override
	public long getOffreemploiId() {
		return model.getOffreemploiId();
	}

	/**
	 * Returns the primary key of this offreemploi.
	 *
	 * @return the primary key of this offreemploi
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the titre of this offreemploi.
	 *
	 * @return the titre of this offreemploi
	 */
	@Override
	public String getTitre() {
		return model.getTitre();
	}

	/**
	 * Returns the uuid of this offreemploi.
	 *
	 * @return the uuid of this offreemploi
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
	 * Sets the date creation of this offreemploi.
	 *
	 * @param dateCreation the date creation of this offreemploi
	 */
	@Override
	public void setDateCreation(Date dateCreation) {
		model.setDateCreation(dateCreation);
	}

	/**
	 * Sets the detail of this offreemploi.
	 *
	 * @param detail the detail of this offreemploi
	 */
	@Override
	public void setDetail(String detail) {
		model.setDetail(detail);
	}

	/**
	 * Sets the offreemploi ID of this offreemploi.
	 *
	 * @param OffreemploiId the offreemploi ID of this offreemploi
	 */
	@Override
	public void setOffreemploiId(long OffreemploiId) {
		model.setOffreemploiId(OffreemploiId);
	}

	/**
	 * Sets the primary key of this offreemploi.
	 *
	 * @param primaryKey the primary key of this offreemploi
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the titre of this offreemploi.
	 *
	 * @param titre the titre of this offreemploi
	 */
	@Override
	public void setTitre(String titre) {
		model.setTitre(titre);
	}

	/**
	 * Sets the uuid of this offreemploi.
	 *
	 * @param uuid the uuid of this offreemploi
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
	protected OffreemploiWrapper wrap(Offreemploi offreemploi) {
		return new OffreemploiWrapper(offreemploi);
	}

}