/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.service.persistence.impl;

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

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import revue.exception.NoSuchRevueException;

import revue.model.Revue;
import revue.model.RevueTable;
import revue.model.impl.RevueImpl;
import revue.model.impl.RevueModelImpl;

import revue.service.persistence.RevuePersistence;
import revue.service.persistence.RevueUtil;
import revue.service.persistence.impl.constants.WAFABAILPersistenceConstants;

/**
 * The persistence implementation for the revue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RevuePersistence.class)
public class RevuePersistenceImpl
	extends BasePersistenceImpl<Revue> implements RevuePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RevueUtil</code> to access the revue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RevueImpl.class.getName();

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
	 * Returns all the revues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching revues
	 */
	@Override
	public List<Revue> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Revue> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Revue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Revue> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Revue> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Revue> orderByComparator, boolean useFinderCache) {

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

		List<Revue> list = null;

		if (useFinderCache) {
			list = (List<Revue>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Revue revue : list) {
					if (!uuid.equals(revue.getUuid())) {
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

			sb.append(_SQL_SELECT_REVUE_WHERE);

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
				sb.append(RevueModelImpl.ORDER_BY_JPQL);
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

				list = (List<Revue>)QueryUtil.list(
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
	 * Returns the first revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching revue
	 * @throws NoSuchRevueException if a matching revue could not be found
	 */
	@Override
	public Revue findByUuid_First(
			String uuid, OrderByComparator<Revue> orderByComparator)
		throws NoSuchRevueException {

		Revue revue = fetchByUuid_First(uuid, orderByComparator);

		if (revue != null) {
			return revue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRevueException(sb.toString());
	}

	/**
	 * Returns the first revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching revue, or <code>null</code> if a matching revue could not be found
	 */
	@Override
	public Revue fetchByUuid_First(
		String uuid, OrderByComparator<Revue> orderByComparator) {

		List<Revue> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching revue
	 * @throws NoSuchRevueException if a matching revue could not be found
	 */
	@Override
	public Revue findByUuid_Last(
			String uuid, OrderByComparator<Revue> orderByComparator)
		throws NoSuchRevueException {

		Revue revue = fetchByUuid_Last(uuid, orderByComparator);

		if (revue != null) {
			return revue;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRevueException(sb.toString());
	}

	/**
	 * Returns the last revue in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching revue, or <code>null</code> if a matching revue could not be found
	 */
	@Override
	public Revue fetchByUuid_Last(
		String uuid, OrderByComparator<Revue> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Revue> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Revue[] findByUuid_PrevAndNext(
			long revueId, String uuid,
			OrderByComparator<Revue> orderByComparator)
		throws NoSuchRevueException {

		uuid = Objects.toString(uuid, "");

		Revue revue = findByPrimaryKey(revueId);

		Session session = null;

		try {
			session = openSession();

			Revue[] array = new RevueImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, revue, uuid, orderByComparator, true);

			array[1] = revue;

			array[2] = getByUuid_PrevAndNext(
				session, revue, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Revue getByUuid_PrevAndNext(
		Session session, Revue revue, String uuid,
		OrderByComparator<Revue> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_REVUE_WHERE);

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
			sb.append(RevueModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(revue)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Revue> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the revues where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Revue revue :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(revue);
		}
	}

	/**
	 * Returns the number of revues where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching revues
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_REVUE_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "revue.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(revue.uuid IS NULL OR revue.uuid = '')";

	public RevuePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Revue.class);

		setModelImplClass(RevueImpl.class);
		setModelPKClass(long.class);

		setTable(RevueTable.INSTANCE);
	}

	/**
	 * Caches the revue in the entity cache if it is enabled.
	 *
	 * @param revue the revue
	 */
	@Override
	public void cacheResult(Revue revue) {
		entityCache.putResult(RevueImpl.class, revue.getPrimaryKey(), revue);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the revues in the entity cache if it is enabled.
	 *
	 * @param revues the revues
	 */
	@Override
	public void cacheResult(List<Revue> revues) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (revues.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Revue revue : revues) {
			if (entityCache.getResult(RevueImpl.class, revue.getPrimaryKey()) ==
					null) {

				cacheResult(revue);
			}
		}
	}

	/**
	 * Clears the cache for all revues.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RevueImpl.class);

		finderCache.clearCache(RevueImpl.class);
	}

	/**
	 * Clears the cache for the revue.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Revue revue) {
		entityCache.removeResult(RevueImpl.class, revue);
	}

	@Override
	public void clearCache(List<Revue> revues) {
		for (Revue revue : revues) {
			entityCache.removeResult(RevueImpl.class, revue);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RevueImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RevueImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new revue with the primary key. Does not add the revue to the database.
	 *
	 * @param revueId the primary key for the new revue
	 * @return the new revue
	 */
	@Override
	public Revue create(long revueId) {
		Revue revue = new RevueImpl();

		revue.setNew(true);
		revue.setPrimaryKey(revueId);

		String uuid = PortalUUIDUtil.generate();

		revue.setUuid(uuid);

		return revue;
	}

	/**
	 * Removes the revue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue that was removed
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	@Override
	public Revue remove(long revueId) throws NoSuchRevueException {
		return remove((Serializable)revueId);
	}

	/**
	 * Removes the revue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the revue
	 * @return the revue that was removed
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	@Override
	public Revue remove(Serializable primaryKey) throws NoSuchRevueException {
		Session session = null;

		try {
			session = openSession();

			Revue revue = (Revue)session.get(RevueImpl.class, primaryKey);

			if (revue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRevueException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(revue);
		}
		catch (NoSuchRevueException noSuchEntityException) {
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
	protected Revue removeImpl(Revue revue) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(revue)) {
				revue = (Revue)session.get(
					RevueImpl.class, revue.getPrimaryKeyObj());
			}

			if (revue != null) {
				session.delete(revue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (revue != null) {
			clearCache(revue);
		}

		return revue;
	}

	@Override
	public Revue updateImpl(Revue revue) {
		boolean isNew = revue.isNew();

		if (!(revue instanceof RevueModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(revue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(revue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in revue proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Revue implementation " +
					revue.getClass());
		}

		RevueModelImpl revueModelImpl = (RevueModelImpl)revue;

		if (Validator.isNull(revue.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			revue.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(revue);
			}
			else {
				revue = (Revue)session.merge(revue);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(RevueImpl.class, revueModelImpl, false, true);

		if (isNew) {
			revue.setNew(false);
		}

		revue.resetOriginalValues();

		return revue;
	}

	/**
	 * Returns the revue with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the revue
	 * @return the revue
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	@Override
	public Revue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRevueException {

		Revue revue = fetchByPrimaryKey(primaryKey);

		if (revue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRevueException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return revue;
	}

	/**
	 * Returns the revue with the primary key or throws a <code>NoSuchRevueException</code> if it could not be found.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue
	 * @throws NoSuchRevueException if a revue with the primary key could not be found
	 */
	@Override
	public Revue findByPrimaryKey(long revueId) throws NoSuchRevueException {
		return findByPrimaryKey((Serializable)revueId);
	}

	/**
	 * Returns the revue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param revueId the primary key of the revue
	 * @return the revue, or <code>null</code> if a revue with the primary key could not be found
	 */
	@Override
	public Revue fetchByPrimaryKey(long revueId) {
		return fetchByPrimaryKey((Serializable)revueId);
	}

	/**
	 * Returns all the revues.
	 *
	 * @return the revues
	 */
	@Override
	public List<Revue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Revue> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Revue> findAll(
		int start, int end, OrderByComparator<Revue> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Revue> findAll(
		int start, int end, OrderByComparator<Revue> orderByComparator,
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

		List<Revue> list = null;

		if (useFinderCache) {
			list = (List<Revue>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_REVUE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_REVUE;

				sql = sql.concat(RevueModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Revue>)QueryUtil.list(
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
	 * Removes all the revues from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Revue revue : findAll()) {
			remove(revue);
		}
	}

	/**
	 * Returns the number of revues.
	 *
	 * @return the number of revues
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_REVUE);

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
		return "revueId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_REVUE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RevueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the revue persistence.
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

		RevueUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		RevueUtil.setPersistence(null);

		entityCache.removeCache(RevueImpl.class.getName());
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

	private static final String _SQL_SELECT_REVUE =
		"SELECT revue FROM Revue revue";

	private static final String _SQL_SELECT_REVUE_WHERE =
		"SELECT revue FROM Revue revue WHERE ";

	private static final String _SQL_COUNT_REVUE =
		"SELECT COUNT(revue) FROM Revue revue";

	private static final String _SQL_COUNT_REVUE_WHERE =
		"SELECT COUNT(revue) FROM Revue revue WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "revue.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Revue exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Revue exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RevuePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}