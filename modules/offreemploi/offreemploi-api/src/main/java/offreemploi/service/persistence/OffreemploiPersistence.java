/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import offreemploi.exception.NoSuchOffreemploiException;

import offreemploi.model.Offreemploi;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the offreemploi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OffreemploiUtil
 * @generated
 */
@ProviderType
public interface OffreemploiPersistence extends BasePersistence<Offreemploi> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OffreemploiUtil} to access the offreemploi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the offreemplois where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offreemplois
	 */
	public java.util.List<Offreemploi> findByUuid(String uuid);

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
	public java.util.List<Offreemploi> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<Offreemploi> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
			orderByComparator);

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
	public java.util.List<Offreemploi> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offreemploi
	 * @throws NoSuchOffreemploiException if a matching offreemploi could not be found
	 */
	public Offreemploi findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
				orderByComparator)
		throws NoSuchOffreemploiException;

	/**
	 * Returns the first offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offreemploi, or <code>null</code> if a matching offreemploi could not be found
	 */
	public Offreemploi fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
			orderByComparator);

	/**
	 * Returns the last offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offreemploi
	 * @throws NoSuchOffreemploiException if a matching offreemploi could not be found
	 */
	public Offreemploi findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
				orderByComparator)
		throws NoSuchOffreemploiException;

	/**
	 * Returns the last offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offreemploi, or <code>null</code> if a matching offreemploi could not be found
	 */
	public Offreemploi fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
			orderByComparator);

	/**
	 * Returns the offreemplois before and after the current offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param OffreemploiId the primary key of the current offreemploi
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next offreemploi
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	public Offreemploi[] findByUuid_PrevAndNext(
			long OffreemploiId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
				orderByComparator)
		throws NoSuchOffreemploiException;

	/**
	 * Removes all the offreemplois where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of offreemplois where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offreemplois
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the offreemploi in the entity cache if it is enabled.
	 *
	 * @param offreemploi the offreemploi
	 */
	public void cacheResult(Offreemploi offreemploi);

	/**
	 * Caches the offreemplois in the entity cache if it is enabled.
	 *
	 * @param offreemplois the offreemplois
	 */
	public void cacheResult(java.util.List<Offreemploi> offreemplois);

	/**
	 * Creates a new offreemploi with the primary key. Does not add the offreemploi to the database.
	 *
	 * @param OffreemploiId the primary key for the new offreemploi
	 * @return the new offreemploi
	 */
	public Offreemploi create(long OffreemploiId);

	/**
	 * Removes the offreemploi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi that was removed
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	public Offreemploi remove(long OffreemploiId)
		throws NoSuchOffreemploiException;

	public Offreemploi updateImpl(Offreemploi offreemploi);

	/**
	 * Returns the offreemploi with the primary key or throws a <code>NoSuchOffreemploiException</code> if it could not be found.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	public Offreemploi findByPrimaryKey(long OffreemploiId)
		throws NoSuchOffreemploiException;

	/**
	 * Returns the offreemploi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi, or <code>null</code> if a offreemploi with the primary key could not be found
	 */
	public Offreemploi fetchByPrimaryKey(long OffreemploiId);

	/**
	 * Returns all the offreemplois.
	 *
	 * @return the offreemplois
	 */
	public java.util.List<Offreemploi> findAll();

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
	public java.util.List<Offreemploi> findAll(int start, int end);

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
	public java.util.List<Offreemploi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
			orderByComparator);

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
	public java.util.List<Offreemploi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Offreemploi>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the offreemplois from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of offreemplois.
	 *
	 * @return the number of offreemplois
	 */
	public int countAll();

}