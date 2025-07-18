/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import offrestage.model.Offrestage;

/**
 * The persistence utility for the offrestage service. This utility wraps <code>offrestage.service.persistence.impl.OffrestagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OffrestagePersistence
 * @generated
 */
public class OffrestageUtil {

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
	public static void clearCache(Offrestage offrestage) {
		getPersistence().clearCache(offrestage);
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
	public static Map<Serializable, Offrestage> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Offrestage> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Offrestage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Offrestage> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Offrestage> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Offrestage update(Offrestage offrestage) {
		return getPersistence().update(offrestage);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Offrestage update(
		Offrestage offrestage, ServiceContext serviceContext) {

		return getPersistence().update(offrestage, serviceContext);
	}

	/**
	 * Returns all the offrestages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offrestages
	 */
	public static List<Offrestage> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the offrestages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffrestageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offrestages
	 * @param end the upper bound of the range of offrestages (not inclusive)
	 * @return the range of matching offrestages
	 */
	public static List<Offrestage> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the offrestages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffrestageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offrestages
	 * @param end the upper bound of the range of offrestages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offrestages
	 */
	public static List<Offrestage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offrestage> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offrestages where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffrestageModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offrestages
	 * @param end the upper bound of the range of offrestages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offrestages
	 */
	public static List<Offrestage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offrestage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offrestage
	 * @throws NoSuchOffrestageException if a matching offrestage could not be found
	 */
	public static Offrestage findByUuid_First(
			String uuid, OrderByComparator<Offrestage> orderByComparator)
		throws offrestage.exception.NoSuchOffrestageException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offrestage, or <code>null</code> if a matching offrestage could not be found
	 */
	public static Offrestage fetchByUuid_First(
		String uuid, OrderByComparator<Offrestage> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offrestage
	 * @throws NoSuchOffrestageException if a matching offrestage could not be found
	 */
	public static Offrestage findByUuid_Last(
			String uuid, OrderByComparator<Offrestage> orderByComparator)
		throws offrestage.exception.NoSuchOffrestageException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offrestage, or <code>null</code> if a matching offrestage could not be found
	 */
	public static Offrestage fetchByUuid_Last(
		String uuid, OrderByComparator<Offrestage> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the offrestages before and after the current offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param stageId the primary key of the current offrestage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offrestage
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	public static Offrestage[] findByUuid_PrevAndNext(
			long stageId, String uuid,
			OrderByComparator<Offrestage> orderByComparator)
		throws offrestage.exception.NoSuchOffrestageException {

		return getPersistence().findByUuid_PrevAndNext(
			stageId, uuid, orderByComparator);
	}

	/**
	 * Removes all the offrestages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of offrestages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offrestages
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the offrestage in the entity cache if it is enabled.
	 *
	 * @param offrestage the offrestage
	 */
	public static void cacheResult(Offrestage offrestage) {
		getPersistence().cacheResult(offrestage);
	}

	/**
	 * Caches the offrestages in the entity cache if it is enabled.
	 *
	 * @param offrestages the offrestages
	 */
	public static void cacheResult(List<Offrestage> offrestages) {
		getPersistence().cacheResult(offrestages);
	}

	/**
	 * Creates a new offrestage with the primary key. Does not add the offrestage to the database.
	 *
	 * @param stageId the primary key for the new offrestage
	 * @return the new offrestage
	 */
	public static Offrestage create(long stageId) {
		return getPersistence().create(stageId);
	}

	/**
	 * Removes the offrestage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage that was removed
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	public static Offrestage remove(long stageId)
		throws offrestage.exception.NoSuchOffrestageException {

		return getPersistence().remove(stageId);
	}

	public static Offrestage updateImpl(Offrestage offrestage) {
		return getPersistence().updateImpl(offrestage);
	}

	/**
	 * Returns the offrestage with the primary key or throws a <code>NoSuchOffrestageException</code> if it could not be found.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	public static Offrestage findByPrimaryKey(long stageId)
		throws offrestage.exception.NoSuchOffrestageException {

		return getPersistence().findByPrimaryKey(stageId);
	}

	/**
	 * Returns the offrestage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage, or <code>null</code> if a offrestage with the primary key could not be found
	 */
	public static Offrestage fetchByPrimaryKey(long stageId) {
		return getPersistence().fetchByPrimaryKey(stageId);
	}

	/**
	 * Returns all the offrestages.
	 *
	 * @return the offrestages
	 */
	public static List<Offrestage> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the offrestages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffrestageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offrestages
	 * @param end the upper bound of the range of offrestages (not inclusive)
	 * @return the range of offrestages
	 */
	public static List<Offrestage> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the offrestages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffrestageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offrestages
	 * @param end the upper bound of the range of offrestages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offrestages
	 */
	public static List<Offrestage> findAll(
		int start, int end, OrderByComparator<Offrestage> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offrestages.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffrestageModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offrestages
	 * @param end the upper bound of the range of offrestages (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of offrestages
	 */
	public static List<Offrestage> findAll(
		int start, int end, OrderByComparator<Offrestage> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the offrestages from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of offrestages.
	 *
	 * @return the number of offrestages
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OffrestagePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(OffrestagePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile OffrestagePersistence _persistence;

}