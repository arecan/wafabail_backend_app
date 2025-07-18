/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import offrestage.exception.NoSuchOffrestageException;

import offrestage.model.Offrestage;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the offrestage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OffrestageUtil
 * @generated
 */
@ProviderType
public interface OffrestagePersistence extends BasePersistence<Offrestage> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OffrestageUtil} to access the offrestage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the offrestages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offrestages
	 */
	public java.util.List<Offrestage> findByUuid(String uuid);

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
	public java.util.List<Offrestage> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Offrestage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
			orderByComparator);

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
	public java.util.List<Offrestage> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offrestage
	 * @throws NoSuchOffrestageException if a matching offrestage could not be found
	 */
	public Offrestage findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
				orderByComparator)
		throws NoSuchOffrestageException;

	/**
	 * Returns the first offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offrestage, or <code>null</code> if a matching offrestage could not be found
	 */
	public Offrestage fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
			orderByComparator);

	/**
	 * Returns the last offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offrestage
	 * @throws NoSuchOffrestageException if a matching offrestage could not be found
	 */
	public Offrestage findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
				orderByComparator)
		throws NoSuchOffrestageException;

	/**
	 * Returns the last offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offrestage, or <code>null</code> if a matching offrestage could not be found
	 */
	public Offrestage fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
			orderByComparator);

	/**
	 * Returns the offrestages before and after the current offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param stageId the primary key of the current offrestage
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offrestage
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	public Offrestage[] findByUuid_PrevAndNext(
			long stageId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
				orderByComparator)
		throws NoSuchOffrestageException;

	/**
	 * Removes all the offrestages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of offrestages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offrestages
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the offrestage in the entity cache if it is enabled.
	 *
	 * @param offrestage the offrestage
	 */
	public void cacheResult(Offrestage offrestage);

	/**
	 * Caches the offrestages in the entity cache if it is enabled.
	 *
	 * @param offrestages the offrestages
	 */
	public void cacheResult(java.util.List<Offrestage> offrestages);

	/**
	 * Creates a new offrestage with the primary key. Does not add the offrestage to the database.
	 *
	 * @param stageId the primary key for the new offrestage
	 * @return the new offrestage
	 */
	public Offrestage create(long stageId);

	/**
	 * Removes the offrestage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage that was removed
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	public Offrestage remove(long stageId) throws NoSuchOffrestageException;

	public Offrestage updateImpl(Offrestage offrestage);

	/**
	 * Returns the offrestage with the primary key or throws a <code>NoSuchOffrestageException</code> if it could not be found.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	public Offrestage findByPrimaryKey(long stageId)
		throws NoSuchOffrestageException;

	/**
	 * Returns the offrestage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage, or <code>null</code> if a offrestage with the primary key could not be found
	 */
	public Offrestage fetchByPrimaryKey(long stageId);

	/**
	 * Returns all the offrestages.
	 *
	 * @return the offrestages
	 */
	public java.util.List<Offrestage> findAll();

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
	public java.util.List<Offrestage> findAll(int start, int end);

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
	public java.util.List<Offrestage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
			orderByComparator);

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
	public java.util.List<Offrestage> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offrestage>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the offrestages from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of offrestages.
	 *
	 * @return the number of offrestages
	 */
	public int countAll();

}