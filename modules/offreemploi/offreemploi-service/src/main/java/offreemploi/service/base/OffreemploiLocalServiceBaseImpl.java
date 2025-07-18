/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.service.base;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import offreemploi.model.Offreemploi;

import offreemploi.service.OffreemploiLocalService;
import offreemploi.service.OffreemploiLocalServiceUtil;
import offreemploi.service.persistence.OffreemploiPersistence;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the offreemploi local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link offreemploi.service.impl.OffreemploiLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see offreemploi.service.impl.OffreemploiLocalServiceImpl
 * @generated
 */
public abstract class OffreemploiLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, OffreemploiLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>OffreemploiLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>OffreemploiLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Offreemploi addOffreemploi(Offreemploi offreemploi) {
		offreemploi.setNew(true);

		return offreemploiPersistence.update(offreemploi);
	}

	/**
	 * Creates a new offreemploi with the primary key. Does not add the offreemploi to the database.
	 *
	 * @param OffreemploiId the primary key for the new offreemploi
	 * @return the new offreemploi
	 */
	@Override
	@Transactional(enabled = false)
	public Offreemploi createOffreemploi(long OffreemploiId) {
		return offreemploiPersistence.create(OffreemploiId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Offreemploi deleteOffreemploi(long OffreemploiId)
		throws PortalException {

		return offreemploiPersistence.remove(OffreemploiId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Offreemploi deleteOffreemploi(Offreemploi offreemploi) {
		return offreemploiPersistence.remove(offreemploi);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return offreemploiPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Offreemploi.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return offreemploiPersistence.findWithDynamicQuery(dynamicQuery);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return offreemploiPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return offreemploiPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return offreemploiPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return offreemploiPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Offreemploi fetchOffreemploi(long OffreemploiId) {
		return offreemploiPersistence.fetchByPrimaryKey(OffreemploiId);
	}

	/**
	 * Returns the offreemploi with the primary key.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi
	 * @throws PortalException if a offreemploi with the primary key could not be found
	 */
	@Override
	public Offreemploi getOffreemploi(long OffreemploiId)
		throws PortalException {

		return offreemploiPersistence.findByPrimaryKey(OffreemploiId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(offreemploiLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Offreemploi.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("OffreemploiId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			offreemploiLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Offreemploi.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"OffreemploiId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(offreemploiLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Offreemploi.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("OffreemploiId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return offreemploiPersistence.create(((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement OffreemploiLocalServiceImpl#deleteOffreemploi(Offreemploi) to avoid orphaned data");
		}

		return offreemploiLocalService.deleteOffreemploi(
			(Offreemploi)persistedModel);
	}

	@Override
	public BasePersistence<Offreemploi> getBasePersistence() {
		return offreemploiPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return offreemploiPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<Offreemploi> getOffreemplois(int start, int end) {
		return offreemploiPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of offreemplois.
	 *
	 * @return the number of offreemplois
	 */
	@Override
	public int getOffreemploisCount() {
		return offreemploiPersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Offreemploi updateOffreemploi(Offreemploi offreemploi) {
		return offreemploiPersistence.update(offreemploi);
	}

	@Deactivate
	protected void deactivate() {
		OffreemploiLocalServiceUtil.setService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			OffreemploiLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		offreemploiLocalService = (OffreemploiLocalService)aopProxy;

		OffreemploiLocalServiceUtil.setService(offreemploiLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return OffreemploiLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Offreemploi.class;
	}

	protected String getModelClassName() {
		return Offreemploi.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = offreemploiPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	protected OffreemploiLocalService offreemploiLocalService;

	@Reference
	protected OffreemploiPersistence offreemploiPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		OffreemploiLocalServiceBaseImpl.class);

}