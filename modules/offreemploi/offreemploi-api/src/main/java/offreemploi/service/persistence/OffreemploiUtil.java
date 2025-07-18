/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import offreemploi.model.Offreemploi;

/**
 * The persistence utility for the offreemploi service. This utility wraps <code>offreemploi.service.persistence.impl.OffreemploiPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OffreemploiPersistence
 * @generated
 */
public class OffreemploiUtil {

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
	public static void clearCache(Offreemploi offreemploi) {
		getPersistence().clearCache(offreemploi);
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
	public static Map<Serializable, Offreemploi> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Offreemploi> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Offreemploi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Offreemploi> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Offreemploi> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Offreemploi update(Offreemploi offreemploi) {
		return getPersistence().update(offreemploi);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Offreemploi update(
		Offreemploi offreemploi, ServiceContext serviceContext) {

		return getPersistence().update(offreemploi, serviceContext);
	}

	/**
	 * Returns all the offreemplois where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offreemplois
	 */
	public static List<Offreemploi> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the offreemplois where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offreemplois
	 * @param end the upper bound of the range of offreemplois (not inclusive)
	 * @return the range of matching offreemplois
	 */
	public static List<Offreemploi> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the offreemplois where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offreemplois
	 * @param end the upper bound of the range of offreemplois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching offreemplois
	 */
	public static List<Offreemploi> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offreemploi> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offreemplois where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of offreemplois
	 * @param end the upper bound of the range of offreemplois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching offreemplois
	 */
	public static List<Offreemploi> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offreemploi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offreemploi
	 * @throws NoSuchOffreemploiException if a matching offreemploi could not be found
	 */
	public static Offreemploi findByUuid_First(
			String uuid, OrderByComparator<Offreemploi> orderByComparator)
		throws offreemploi.exception.NoSuchOffreemploiException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offreemploi, or <code>null</code> if a matching offreemploi could not be found
	 */
	public static Offreemploi fetchByUuid_First(
		String uuid, OrderByComparator<Offreemploi> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offreemploi
	 * @throws NoSuchOffreemploiException if a matching offreemploi could not be found
	 */
	public static Offreemploi findByUuid_Last(
			String uuid, OrderByComparator<Offreemploi> orderByComparator)
		throws offreemploi.exception.NoSuchOffreemploiException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offreemploi, or <code>null</code> if a matching offreemploi could not be found
	 */
	public static Offreemploi fetchByUuid_Last(
		String uuid, OrderByComparator<Offreemploi> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the offreemplois before and after the current offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param OffreemploiId the primary key of the current offreemploi
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offreemploi
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	public static Offreemploi[] findByUuid_PrevAndNext(
			long OffreemploiId, String uuid,
			OrderByComparator<Offreemploi> orderByComparator)
		throws offreemploi.exception.NoSuchOffreemploiException {

		return getPersistence().findByUuid_PrevAndNext(
			OffreemploiId, uuid, orderByComparator);
	}

	/**
	 * Removes all the offreemplois where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of offreemplois where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offreemplois
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the offreemploi in the entity cache if it is enabled.
	 *
	 * @param offreemploi the offreemploi
	 */
	public static void cacheResult(Offreemploi offreemploi) {
		getPersistence().cacheResult(offreemploi);
	}

	/**
	 * Caches the offreemplois in the entity cache if it is enabled.
	 *
	 * @param offreemplois the offreemplois
	 */
	public static void cacheResult(List<Offreemploi> offreemplois) {
		getPersistence().cacheResult(offreemplois);
	}

	/**
	 * Creates a new offreemploi with the primary key. Does not add the offreemploi to the database.
	 *
	 * @param OffreemploiId the primary key for the new offreemploi
	 * @return the new offreemploi
	 */
	public static Offreemploi create(long OffreemploiId) {
		return getPersistence().create(OffreemploiId);
	}

	/**
	 * Removes the offreemploi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi that was removed
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	public static Offreemploi remove(long OffreemploiId)
		throws offreemploi.exception.NoSuchOffreemploiException {

		return getPersistence().remove(OffreemploiId);
	}

	public static Offreemploi updateImpl(Offreemploi offreemploi) {
		return getPersistence().updateImpl(offreemploi);
	}

	/**
	 * Returns the offreemploi with the primary key or throws a <code>NoSuchOffreemploiException</code> if it could not be found.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	public static Offreemploi findByPrimaryKey(long OffreemploiId)
		throws offreemploi.exception.NoSuchOffreemploiException {

		return getPersistence().findByPrimaryKey(OffreemploiId);
	}

	/**
	 * Returns the offreemploi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi, or <code>null</code> if a offreemploi with the primary key could not be found
	 */
	public static Offreemploi fetchByPrimaryKey(long OffreemploiId) {
		return getPersistence().fetchByPrimaryKey(OffreemploiId);
	}

	/**
	 * Returns all the offreemplois.
	 *
	 * @return the offreemplois
	 */
	public static List<Offreemploi> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the offreemplois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offreemplois
	 * @param end the upper bound of the range of offreemplois (not inclusive)
	 * @return the range of offreemplois
	 */
	public static List<Offreemploi> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the offreemplois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offreemplois
	 * @param end the upper bound of the range of offreemplois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of offreemplois
	 */
	public static List<Offreemploi> findAll(
		int start, int end, OrderByComparator<Offreemploi> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the offreemplois.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>OffreemploiModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of offreemplois
	 * @param end the upper bound of the range of offreemplois (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of offreemplois
	 */
	public static List<Offreemploi> findAll(
		int start, int end, OrderByComparator<Offreemploi> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the offreemplois from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of offreemplois.
	 *
	 * @return the number of offreemplois
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static OffreemploiPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(OffreemploiPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile OffreemploiPersistence _persistence;

}