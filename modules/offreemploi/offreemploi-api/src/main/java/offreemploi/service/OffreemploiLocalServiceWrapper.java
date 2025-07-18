/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link OffreemploiLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OffreemploiLocalService
 * @generated
 */
public class OffreemploiLocalServiceWrapper
	implements OffreemploiLocalService,
			   ServiceWrapper<OffreemploiLocalService> {

	public OffreemploiLocalServiceWrapper() {
		this(null);
	}

	public OffreemploiLocalServiceWrapper(
		OffreemploiLocalService offreemploiLocalService) {

		_offreemploiLocalService = offreemploiLocalService;
	}

	/**
	 * Adds the offreemploi to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffreemploiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offreemploi the offreemploi
	 * @return the offreemploi that was added
	 */
	@Override
	public offreemploi.model.Offreemploi addOffreemploi(
		offreemploi.model.Offreemploi offreemploi) {

		return _offreemploiLocalService.addOffreemploi(offreemploi);
	}

	@Override
	public offreemploi.model.Offreemploi addOffreemploi(
		String titre, String detail) {

		return _offreemploiLocalService.addOffreemploi(titre, detail);
	}

	/**
	 * Creates a new offreemploi with the primary key. Does not add the offreemploi to the database.
	 *
	 * @param OffreemploiId the primary key for the new offreemploi
	 * @return the new offreemploi
	 */
	@Override
	public offreemploi.model.Offreemploi createOffreemploi(long OffreemploiId) {
		return _offreemploiLocalService.createOffreemploi(OffreemploiId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offreemploiLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the offreemploi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffreemploiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi that was removed
	 * @throws PortalException if a offreemploi with the primary key could not be found
	 */
	@Override
	public offreemploi.model.Offreemploi deleteOffreemploi(long OffreemploiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offreemploiLocalService.deleteOffreemploi(OffreemploiId);
	}

	/**
	 * Deletes the offreemploi from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffreemploiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offreemploi the offreemploi
	 * @return the offreemploi that was removed
	 */
	@Override
	public offreemploi.model.Offreemploi deleteOffreemploi(
		offreemploi.model.Offreemploi offreemploi) {

		return _offreemploiLocalService.deleteOffreemploi(offreemploi);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offreemploiLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _offreemploiLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _offreemploiLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _offreemploiLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _offreemploiLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>offreemploi.model.impl.OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _offreemploiLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>offreemploi.model.impl.OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _offreemploiLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _offreemploiLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _offreemploiLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public offreemploi.model.Offreemploi fetchOffreemploi(long OffreemploiId) {
		return _offreemploiLocalService.fetchOffreemploi(OffreemploiId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _offreemploiLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<offreemploi.model.Offreemploi> getAllOffreemplois() {
		return _offreemploiLocalService.getAllOffreemplois();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _offreemploiLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the offreemploi with the primary key.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi
	 * @throws PortalException if a offreemploi with the primary key could not be found
	 */
	@Override
	public offreemploi.model.Offreemploi getOffreemploi(long OffreemploiId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offreemploiLocalService.getOffreemploi(OffreemploiId);
	}

	/**
	 * Returns a range of all the offreemplois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>offreemploi.model.impl.OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offreemplois
	 * @param end the upper bound of the range of offreemplois (not inclusive)
	 * @return the range of offreemplois
	 */
	@Override
	public java.util.List<offreemploi.model.Offreemploi> getOffreemplois(
		int start, int end) {

		return _offreemploiLocalService.getOffreemplois(start, end);
	}

	/**
	 * Returns the number of offreemplois.
	 *
	 * @return the number of offreemplois
	 */
	@Override
	public int getOffreemploisCount() {
		return _offreemploiLocalService.getOffreemploisCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offreemploiLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offreemploiLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public offreemploi.model.Offreemploi updateOffreemploi(
			long offreemploiId, String titre, String detail)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offreemploiLocalService.updateOffreemploi(
			offreemploiId, titre, detail);
	}

	/**
	 * Updates the offreemploi in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffreemploiLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offreemploi the offreemploi
	 * @return the offreemploi that was updated
	 */
	@Override
	public offreemploi.model.Offreemploi updateOffreemploi(
		offreemploi.model.Offreemploi offreemploi) {

		return _offreemploiLocalService.updateOffreemploi(offreemploi);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _offreemploiLocalService.getBasePersistence();
	}

	@Override
	public OffreemploiLocalService getWrappedService() {
		return _offreemploiLocalService;
	}

	@Override
	public void setWrappedService(
		OffreemploiLocalService offreemploiLocalService) {

		_offreemploiLocalService = offreemploiLocalService;
	}

	private OffreemploiLocalService _offreemploiLocalService;

}