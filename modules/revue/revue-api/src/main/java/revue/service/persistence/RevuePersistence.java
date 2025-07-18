/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import revue.exception.NoSuchRevueException;

import revue.model.Revue;

/**
 * The persistence interface for the revue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RevueUtil
 * @generated
 */
@ProviderType
public interface RevuePersistence extends BasePersistence<Revue> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RevueUtil} to access the revue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the revues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching revues
	 */
	public java.util.List<Revue> findByUuid(String uuid);

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
	public java.util.List<Revue> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Revue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Revue>
			orderByComparator);

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
	public java.util.List<Revue> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Revue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching revue
	 * @throws NoSuchRevueException if a matching revue could not be found
	 */
	public Revue findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Revue>
				orderByComparator)
		throws NoSuchRevueException;

	/**
	 * Returns the first revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching revue, or <code>null</code> if a matching revue could not be found
	 */
	public Revue fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Revue>
			orderByComparator);

	/**
	 * Returns the last revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching revue
	 * @throws NoSuchRevueException if a matching revue could not be found
	 */
	public Revue findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Revue>
				orderByComparator)
		throws NoSuchRevueException;

	/**
	 * Returns the last revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching revue, or <code>null</code> if a matching revue could not be found
	 */
	public Revue fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Revue>
			orderByComparator);

	/**
	 * Returns the revues before and after the current revue in the ordered set where uuid = &#63;.
	 *
	 * @param revueId the primary key of the current revue
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next revue
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	public Revue[] findByUuid_PrevAndNext(
			long revueId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Revue>
				orderByComparator)
		throws NoSuchRevueException;

	/**
	 * Removes all the revues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of revues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching revues
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the revue in the entity cache if it is enabled.
	 *
	 * @param revue the revue
	 */
	public void cacheResult(Revue revue);

	/**
	 * Caches the revues in the entity cache if it is enabled.
	 *
	 * @param revues the revues
	 */
	public void cacheResult(java.util.List<Revue> revues);

	/**
	 * Creates a new revue with the primary key. Does not add the revue to the database.
	 *
	 * @param revueId the primary key for the new revue
	 * @return the new revue
	 */
	public Revue create(long revueId);

	/**
	 * Removes the revue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue that was removed
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	public Revue remove(long revueId) throws NoSuchRevueException;

	public Revue updateImpl(Revue revue);

	/**
	 * Returns the revue with the primary key or throws a <code>NoSuchRevueException</code> if it could not be found.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	public Revue findByPrimaryKey(long revueId) throws NoSuchRevueException;

	/**
	 * Returns the revue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue, or <code>null</code> if a revue with the primary key could not be found
	 */
	public Revue fetchByPrimaryKey(long revueId);

	/**
	 * Returns all the revues.
	 *
	 * @return the revues
	 */
	public java.util.List<Revue> findAll();

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
	public java.util.List<Revue> findAll(int start, int end);

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
	public java.util.List<Revue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Revue>
			orderByComparator);

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
	public java.util.List<Revue> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Revue>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the revues from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of revues.
	 *
	 * @return the number of revues
	 */
	public int countAll();

}