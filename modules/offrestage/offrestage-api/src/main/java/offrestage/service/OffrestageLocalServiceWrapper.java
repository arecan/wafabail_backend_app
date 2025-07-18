/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link OffrestageLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OffrestageLocalService
 * @generated
 */
public class OffrestageLocalServiceWrapper
	implements OffrestageLocalService, ServiceWrapper<OffrestageLocalService> {

	public OffrestageLocalServiceWrapper() {
		this(null);
	}

	public OffrestageLocalServiceWrapper(
		OffrestageLocalService offrestageLocalService) {

		_offrestageLocalService = offrestageLocalService;
	}

	/**
	 * Adds the offrestage to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffrestageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offrestage the offrestage
	 * @return the offrestage that was added
	 */
	@Override
	public offrestage.model.Offrestage addOffrestage(
		offrestage.model.Offrestage offrestage) {

		return _offrestageLocalService.addOffrestage(offrestage);
	}

	@Override
	public offrestage.model.Offrestage addStage(String titre, String detail) {
		return _offrestageLocalService.addStage(titre, detail);
	}

	/**
	 * Creates a new offrestage with the primary key. Does not add the offrestage to the database.
	 *
	 * @param stageId the primary key for the new offrestage
	 * @return the new offrestage
	 */
	@Override
	public offrestage.model.Offrestage createOffrestage(long stageId) {
		return _offrestageLocalService.createOffrestage(stageId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the offrestage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffrestageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage that was removed
	 * @throws PortalException if a offrestage with the primary key could not be found
	 */
	@Override
	public offrestage.model.Offrestage deleteOffrestage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.deleteOffrestage(stageId);
	}

	/**
	 * Deletes the offrestage from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffrestageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offrestage the offrestage
	 * @return the offrestage that was removed
	 */
	@Override
	public offrestage.model.Offrestage deleteOffrestage(
		offrestage.model.Offrestage offrestage) {

		return _offrestageLocalService.deleteOffrestage(offrestage);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public offrestage.model.Offrestage deleteStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.deleteStage(stageId);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _offrestageLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _offrestageLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _offrestageLocalService.dynamicQuery();
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

		return _offrestageLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>offrestage.model.impl.OffrestageModelImpl</code>.
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

		return _offrestageLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>offrestage.model.impl.OffrestageModelImpl</code>.
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

		return _offrestageLocalService.dynamicQuery(
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

		return _offrestageLocalService.dynamicQueryCount(dynamicQuery);
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

		return _offrestageLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public offrestage.model.Offrestage fetchOffrestage(long stageId) {
		return _offrestageLocalService.fetchOffrestage(stageId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _offrestageLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<offrestage.model.Offrestage> getAllStages() {
		return _offrestageLocalService.getAllStages();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _offrestageLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the offrestage with the primary key.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage
	 * @throws PortalException if a offrestage with the primary key could not be found
	 */
	@Override
	public offrestage.model.Offrestage getOffrestage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.getOffrestage(stageId);
	}

	/**
	 * Returns a range of all the offrestages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>offrestage.model.impl.OffrestageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offrestages
	 * @param end the upper bound of the range of offrestages (not inclusive)
	 * @return the range of offrestages
	 */
	@Override
	public java.util.List<offrestage.model.Offrestage> getOffrestages(
		int start, int end) {

		return _offrestageLocalService.getOffrestages(start, end);
	}

	/**
	 * Returns the number of offrestages.
	 *
	 * @return the number of offrestages
	 */
	@Override
	public int getOffrestagesCount() {
		return _offrestageLocalService.getOffrestagesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _offrestageLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public offrestage.model.Offrestage getStage(long stageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.getStage(stageId);
	}

	@Override
	public java.util.List<offrestage.model.Offrestage> getStages(
		int start, int end) {

		return _offrestageLocalService.getStages(start, end);
	}

	/**
	 * Updates the offrestage in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect OffrestageLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param offrestage the offrestage
	 * @return the offrestage that was updated
	 */
	@Override
	public offrestage.model.Offrestage updateOffrestage(
		offrestage.model.Offrestage offrestage) {

		return _offrestageLocalService.updateOffrestage(offrestage);
	}

	@Override
	public offrestage.model.Offrestage updateStage(
			long stageId, String titre, String detail)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _offrestageLocalService.updateStage(stageId, titre, detail);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _offrestageLocalService.getBasePersistence();
	}

	@Override
	public OffrestageLocalService getWrappedService() {
		return _offrestageLocalService;
	}

	@Override
	public void setWrappedService(
		OffrestageLocalService offrestageLocalService) {

		_offrestageLocalService = offrestageLocalService;
	}

	private OffrestageLocalService _offrestageLocalService;

}