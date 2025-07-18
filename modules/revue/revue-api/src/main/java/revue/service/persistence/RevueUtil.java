/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import revue.model.Revue;

/**
 * The persistence utility for the revue service. This utility wraps <code>revue.service.persistence.impl.RevuePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RevuePersistence
 * @generated
 */
public class RevueUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Revue revue) {
		getPersistence().clearCache(revue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Revue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Revue> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Revue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Revue> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Revue> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Revue update(Revue revue) {
		return getPersistence().update(revue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Revue update(Revue revue, ServiceContext serviceContext) {
		return getPersistence().update(revue, serviceContext);
	}

	/**
	 * Returns all the revues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching revues
	 */
	public static List<Revue> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the revues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RevueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of revues
	 * @param end the upper bound of the range of revues (not inclusive)
	 * @return the range of matching revues
	 */
	public static List<Revue> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the revues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RevueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of revues
	 * @param end the upper bound of the range of revues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching revues
	 */
	public static List<Revue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Revue> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the revues where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RevueModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of revues
	 * @param end the upper bound of the range of revues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching revues
	 */
	public static List<Revue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Revue> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching revue
	 * @throws NoSuchRevueException if a matching revue could not be found
	 */
	public static Revue findByUuid_First(
			String uuid, OrderByComparator<Revue> orderByComparator)
		throws revue.exception.NoSuchRevueException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching revue, or <code>null</code> if a matching revue could not be found
	 */
	public static Revue fetchByUuid_First(
		String uuid, OrderByComparator<Revue> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching revue
	 * @throws NoSuchRevueException if a matching revue could not be found
	 */
	public static Revue findByUuid_Last(
			String uuid, OrderByComparator<Revue> orderByComparator)
		throws revue.exception.NoSuchRevueException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching revue, or <code>null</code> if a matching revue could not be found
	 */
	public static Revue fetchByUuid_Last(
		String uuid, OrderByComparator<Revue> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the revues before and after the current revue in the ordered set where uuid = &#63;.
	 *
	 * @param revueId the primary key of the current revue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next revue
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	public static Revue[] findByUuid_PrevAndNext(
			long revueId, String uuid,
			OrderByComparator<Revue> orderByComparator)
		throws revue.exception.NoSuchRevueException {

		return getPersistence().findByUuid_PrevAndNext(
			revueId, uuid, orderByComparator);
	}

	/**
	 * Removes all the revues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of revues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching revues
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the revue in the entity cache if it is enabled.
	 *
	 * @param revue the revue
	 */
	public static void cacheResult(Revue revue) {
		getPersistence().cacheResult(revue);
	}

	/**
	 * Caches the revues in the entity cache if it is enabled.
	 *
	 * @param revues the revues
	 */
	public static void cacheResult(List<Revue> revues) {
		getPersistence().cacheResult(revues);
	}

	/**
	 * Creates a new revue with the primary key. Does not add the revue to the database.
	 *
	 * @param revueId the primary key for the new revue
	 * @return the new revue
	 */
	public static Revue create(long revueId) {
		return getPersistence().create(revueId);
	}

	/**
	 * Removes the revue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue that was removed
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	public static Revue remove(long revueId)
		throws revue.exception.NoSuchRevueException {

		return getPersistence().remove(revueId);
	}

	public static Revue updateImpl(Revue revue) {
		return getPersistence().updateImpl(revue);
	}

	/**
	 * Returns the revue with the primary key or throws a <code>NoSuchRevueException</code> if it could not be found.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	public static Revue findByPrimaryKey(long revueId)
		throws revue.exception.NoSuchRevueException {

		return getPersistence().findByPrimaryKey(revueId);
	}

	/**
	 * Returns the revue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue, or <code>null</code> if a revue with the primary key could not be found
	 */
	public static Revue fetchByPrimaryKey(long revueId) {
		return getPersistence().fetchByPrimaryKey(revueId);
	}

	/**
	 * Returns all the revues.
	 *
	 * @return the revues
	 */
	public static List<Revue> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the revues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RevueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of revues
	 * @param end the upper bound of the range of revues (not inclusive)
	 * @return the range of revues
	 */
	public static List<Revue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the revues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RevueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of revues
	 * @param end the upper bound of the range of revues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of revues
	 */
	public static List<Revue> findAll(
		int start, int end, OrderByComparator<Revue> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the revues.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RevueModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of revues
	 * @param end the upper bound of the range of revues (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of revues
	 */
	public static List<Revue> findAll(
		int start, int end, OrderByComparator<Revue> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the revues from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of revues.
	 *
	 * @return the number of revues
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RevuePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(RevuePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile RevuePersistence _persistence;

}