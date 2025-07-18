/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link RevueLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RevueLocalService
 * @generated
 */
public class RevueLocalServiceWrapper
	implements RevueLocalService, ServiceWrapper<RevueLocalService> {

	public RevueLocalServiceWrapper() {
		this(null);
	}

	public RevueLocalServiceWrapper(RevueLocalService revueLocalService) {
		_revueLocalService = revueLocalService;
	}

	/**
	 * Adds the revue to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RevueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param revue the revue
	 * @return the revue that was added
	 */
	@Override
	public revue.model.Revue addRevue(revue.model.Revue revue) {
		return _revueLocalService.addRevue(revue);
	}

	@Override
	public revue.model.Revue addRevue(
		String titre, String details, String lien) {

		return _revueLocalService.addRevue(titre, details, lien);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _revueLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new revue with the primary key. Does not add the revue to the database.
	 *
	 * @param revueId the primary key for the new revue
	 * @return the new revue
	 */
	@Override
	public revue.model.Revue createRevue(long revueId) {
		return _revueLocalService.createRevue(revueId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _revueLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the revue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RevueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue that was removed
	 * @throws PortalException if a revue with the primary key could not be found
	 */
	@Override
	public revue.model.Revue deleteRevue(long revueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _revueLocalService.deleteRevue(revueId);
	}

	/**
	 * Deletes the revue from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RevueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param revue the revue
	 * @return the revue that was removed
	 */
	@Override
	public revue.model.Revue deleteRevue(revue.model.Revue revue) {
		return _revueLocalService.deleteRevue(revue);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _revueLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _revueLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _revueLocalService.dynamicQuery();
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

		return _revueLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>revue.model.impl.RevueModelImpl</code>.
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

		return _revueLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>revue.model.impl.RevueModelImpl</code>.
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

		return _revueLocalService.dynamicQuery(
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

		return _revueLocalService.dynamicQueryCount(dynamicQuery);
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

		return _revueLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public revue.model.Revue fetchRevue(long revueId) {
		return _revueLocalService.fetchRevue(revueId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _revueLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<revue.model.Revue> getAllRevues() {
		return _revueLocalService.getAllRevues();
	}

	@Override
	public java.util.List<revue.model.Revue> getAllRevues(int start, int end) {
		return _revueLocalService.getAllRevues(start, end);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _revueLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _revueLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _revueLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the revue with the primary key.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue
	 * @throws PortalException if a revue with the primary key could not be found
	 */
	@Override
	public revue.model.Revue getRevue(long revueId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _revueLocalService.getRevue(revueId);
	}

	/**
	 * Returns a range of all the revues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>revue.model.impl.RevueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of revues
	 * @param end the upper bound of the range of revues (not inclusive)
	 * @return the range of revues
	 */
	@Override
	public java.util.List<revue.model.Revue> getRevues(int start, int end) {
		return _revueLocalService.getRevues(start, end);
	}

	/**
	 * Returns the number of revues.
	 *
	 * @return the number of revues
	 */
	@Override
	public int getRevuesCount() {
		return _revueLocalService.getRevuesCount();
	}

	@Override
	public revue.model.Revue updateRevue(
			long revueId, String titre, String details, String lien)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _revueLocalService.updateRevue(revueId, titre, details, lien);
	}

	/**
	 * Updates the revue in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect RevueLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param revue the revue
	 * @return the revue that was updated
	 */
	@Override
	public revue.model.Revue updateRevue(revue.model.Revue revue) {
		return _revueLocalService.updateRevue(revue);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _revueLocalService.getBasePersistence();
	}

	@Override
	public RevueLocalService getWrappedService() {
		return _revueLocalService;
	}

	@Override
	public void setWrappedService(RevueLocalService revueLocalService) {
		_revueLocalService = revueLocalService;
	}

	private RevueLocalService _revueLocalService;

}