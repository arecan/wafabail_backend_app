/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import offreemploi.exception.NoSuchOffreemploiException;

import offreemploi.model.Offreemploi;
import offreemploi.model.OffreemploiTable;
import offreemploi.model.impl.OffreemploiImpl;
import offreemploi.model.impl.OffreemploiModelImpl;

import offreemploi.service.persistence.OffreemploiPersistence;
import offreemploi.service.persistence.OffreemploiUtil;
import offreemploi.service.persistence.impl.constants.WAFABAILPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the offreemploi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OffreemploiPersistence.class)
public class OffreemploiPersistenceImpl
	extends BasePersistenceImpl<Offreemploi> implements OffreemploiPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OffreemploiUtil</code> to access the offreemploi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OffreemploiImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the offreemplois where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offreemplois
	 */
	@Override
	public List<Offreemploi> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Offreemploi> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Offreemploi> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offreemploi> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Offreemploi> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offreemploi> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Offreemploi> list = null;

		if (useFinderCache) {
			list = (List<Offreemploi>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Offreemploi offreemploi : list) {
					if (!uuid.equals(offreemploi.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_OFFREEMPLOI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(OffreemploiModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Offreemploi>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offreemploi
	 * @throws NoSuchOffreemploiException if a matching offreemploi could not be found
	 */
	@Override
	public Offreemploi findByUuid_First(
			String uuid, OrderByComparator<Offreemploi> orderByComparator)
		throws NoSuchOffreemploiException {

		Offreemploi offreemploi = fetchByUuid_First(uuid, orderByComparator);

		if (offreemploi != null) {
			return offreemploi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOffreemploiException(sb.toString());
	}

	/**
	 * Returns the first offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offreemploi, or <code>null</code> if a matching offreemploi could not be found
	 */
	@Override
	public Offreemploi fetchByUuid_First(
		String uuid, OrderByComparator<Offreemploi> orderByComparator) {

		List<Offreemploi> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offreemploi
	 * @throws NoSuchOffreemploiException if a matching offreemploi could not be found
	 */
	@Override
	public Offreemploi findByUuid_Last(
			String uuid, OrderByComparator<Offreemploi> orderByComparator)
		throws NoSuchOffreemploiException {

		Offreemploi offreemploi = fetchByUuid_Last(uuid, orderByComparator);

		if (offreemploi != null) {
			return offreemploi;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOffreemploiException(sb.toString());
	}

	/**
	 * Returns the last offreemploi in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offreemploi, or <code>null</code> if a matching offreemploi could not be found
	 */
	@Override
	public Offreemploi fetchByUuid_Last(
		String uuid, OrderByComparator<Offreemploi> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Offreemploi> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Offreemploi[] findByUuid_PrevAndNext(
			long OffreemploiId, String uuid,
			OrderByComparator<Offreemploi> orderByComparator)
		throws NoSuchOffreemploiException {

		uuid = Objects.toString(uuid, "");

		Offreemploi offreemploi = findByPrimaryKey(OffreemploiId);

		Session session = null;

		try {
			session = openSession();

			Offreemploi[] array = new OffreemploiImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, offreemploi, uuid, orderByComparator, true);

			array[1] = offreemploi;

			array[2] = getByUuid_PrevAndNext(
				session, offreemploi, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Offreemploi getByUuid_PrevAndNext(
		Session session, Offreemploi offreemploi, String uuid,
		OrderByComparator<Offreemploi> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OFFREEMPLOI_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(OffreemploiModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(offreemploi)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Offreemploi> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the offreemplois where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Offreemploi offreemploi :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(offreemploi);
		}
	}

	/**
	 * Returns the number of offreemplois where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offreemplois
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OFFREEMPLOI_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"offreemploi.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(offreemploi.uuid IS NULL OR offreemploi.uuid = '')";

	public OffreemploiPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Offreemploi.class);

		setModelImplClass(OffreemploiImpl.class);
		setModelPKClass(long.class);

		setTable(OffreemploiTable.INSTANCE);
	}

	/**
	 * Caches the offreemploi in the entity cache if it is enabled.
	 *
	 * @param offreemploi the offreemploi
	 */
	@Override
	public void cacheResult(Offreemploi offreemploi) {
		entityCache.putResult(
			OffreemploiImpl.class, offreemploi.getPrimaryKey(), offreemploi);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the offreemplois in the entity cache if it is enabled.
	 *
	 * @param offreemplois the offreemplois
	 */
	@Override
	public void cacheResult(List<Offreemploi> offreemplois) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (offreemplois.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Offreemploi offreemploi : offreemplois) {
			if (entityCache.getResult(
					OffreemploiImpl.class, offreemploi.getPrimaryKey()) ==
						null) {

				cacheResult(offreemploi);
			}
		}
	}

	/**
	 * Clears the cache for all offreemplois.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OffreemploiImpl.class);

		finderCache.clearCache(OffreemploiImpl.class);
	}

	/**
	 * Clears the cache for the offreemploi.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Offreemploi offreemploi) {
		entityCache.removeResult(OffreemploiImpl.class, offreemploi);
	}

	@Override
	public void clearCache(List<Offreemploi> offreemplois) {
		for (Offreemploi offreemploi : offreemplois) {
			entityCache.removeResult(OffreemploiImpl.class, offreemploi);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(OffreemploiImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OffreemploiImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new offreemploi with the primary key. Does not add the offreemploi to the database.
	 *
	 * @param OffreemploiId the primary key for the new offreemploi
	 * @return the new offreemploi
	 */
	@Override
	public Offreemploi create(long OffreemploiId) {
		Offreemploi offreemploi = new OffreemploiImpl();

		offreemploi.setNew(true);
		offreemploi.setPrimaryKey(OffreemploiId);

		String uuid = PortalUUIDUtil.generate();

		offreemploi.setUuid(uuid);

		return offreemploi;
	}

	/**
	 * Removes the offreemploi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi that was removed
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	@Override
	public Offreemploi remove(long OffreemploiId)
		throws NoSuchOffreemploiException {

		return remove((Serializable)OffreemploiId);
	}

	/**
	 * Removes the offreemploi with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the offreemploi
	 * @return the offreemploi that was removed
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	@Override
	public Offreemploi remove(Serializable primaryKey)
		throws NoSuchOffreemploiException {

		Session session = null;

		try {
			session = openSession();

			Offreemploi offreemploi = (Offreemploi)session.get(
				OffreemploiImpl.class, primaryKey);

			if (offreemploi == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOffreemploiException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(offreemploi);
		}
		catch (NoSuchOffreemploiException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Offreemploi removeImpl(Offreemploi offreemploi) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(offreemploi)) {
				offreemploi = (Offreemploi)session.get(
					OffreemploiImpl.class, offreemploi.getPrimaryKeyObj());
			}

			if (offreemploi != null) {
				session.delete(offreemploi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (offreemploi != null) {
			clearCache(offreemploi);
		}

		return offreemploi;
	}

	@Override
	public Offreemploi updateImpl(Offreemploi offreemploi) {
		boolean isNew = offreemploi.isNew();

		if (!(offreemploi instanceof OffreemploiModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(offreemploi.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(offreemploi);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in offreemploi proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Offreemploi implementation " +
					offreemploi.getClass());
		}

		OffreemploiModelImpl offreemploiModelImpl =
			(OffreemploiModelImpl)offreemploi;

		if (Validator.isNull(offreemploi.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			offreemploi.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(offreemploi);
			}
			else {
				offreemploi = (Offreemploi)session.merge(offreemploi);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OffreemploiImpl.class, offreemploiModelImpl, false, true);

		if (isNew) {
			offreemploi.setNew(false);
		}

		offreemploi.resetOriginalValues();

		return offreemploi;
	}

	/**
	 * Returns the offreemploi with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the offreemploi
	 * @return the offreemploi
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	@Override
	public Offreemploi findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOffreemploiException {

		Offreemploi offreemploi = fetchByPrimaryKey(primaryKey);

		if (offreemploi == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOffreemploiException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return offreemploi;
	}

	/**
	 * Returns the offreemploi with the primary key or throws a <code>NoSuchOffreemploiException</code> if it could not be found.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi
	 * @throws NoSuchOffreemploiException if a offreemploi with the primary key could not be found
	 */
	@Override
	public Offreemploi findByPrimaryKey(long OffreemploiId)
		throws NoSuchOffreemploiException {

		return findByPrimaryKey((Serializable)OffreemploiId);
	}

	/**
	 * Returns the offreemploi with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param OffreemploiId the primary key of the offreemploi
	 * @return the offreemploi, or <code>null</code> if a offreemploi with the primary key could not be found
	 */
	@Override
	public Offreemploi fetchByPrimaryKey(long OffreemploiId) {
		return fetchByPrimaryKey((Serializable)OffreemploiId);
	}

	/**
	 * Returns all the offreemplois.
	 *
	 * @return the offreemplois
	 */
	@Override
	public List<Offreemploi> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Offreemploi> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Offreemploi> findAll(
		int start, int end, OrderByComparator<Offreemploi> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Offreemploi> findAll(
		int start, int end, OrderByComparator<Offreemploi> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Offreemploi> list = null;

		if (useFinderCache) {
			list = (List<Offreemploi>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OFFREEMPLOI);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OFFREEMPLOI;

				sql = sql.concat(OffreemploiModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Offreemploi>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the offreemplois from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Offreemploi offreemploi : findAll()) {
			remove(offreemploi);
		}
	}

	/**
	 * Returns the number of offreemplois.
	 *
	 * @return the number of offreemplois
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OFFREEMPLOI);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "OffreemploiId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OFFREEMPLOI;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OffreemploiModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the offreemploi persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		OffreemploiUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		OffreemploiUtil.setPersistence(null);

		entityCache.removeCache(OffreemploiImpl.class.getName());
	}

	@Override
	@Reference(
		target = WAFABAILPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = WAFABAILPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = WAFABAILPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_OFFREEMPLOI =
		"SELECT offreemploi FROM Offreemploi offreemploi";

	private static final String _SQL_SELECT_OFFREEMPLOI_WHERE =
		"SELECT offreemploi FROM Offreemploi offreemploi WHERE ";

	private static final String _SQL_COUNT_OFFREEMPLOI =
		"SELECT COUNT(offreemploi) FROM Offreemploi offreemploi";

	private static final String _SQL_COUNT_OFFREEMPLOI_WHERE =
		"SELECT COUNT(offreemploi) FROM Offreemploi offreemploi WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "offreemploi.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Offreemploi exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Offreemploi exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OffreemploiPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}