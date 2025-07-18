/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.service.persistence.impl;

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

import offrestage.exception.NoSuchOffrestageException;

import offrestage.model.Offrestage;
import offrestage.model.OffrestageTable;
import offrestage.model.impl.OffrestageImpl;
import offrestage.model.impl.OffrestageModelImpl;

import offrestage.service.persistence.OffrestagePersistence;
import offrestage.service.persistence.OffrestageUtil;
import offrestage.service.persistence.impl.constants.WAFABAILPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the offrestage service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = OffrestagePersistence.class)
public class OffrestagePersistenceImpl
	extends BasePersistenceImpl<Offrestage> implements OffrestagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>OffrestageUtil</code> to access the offrestage persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		OffrestageImpl.class.getName();

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
	 * Returns all the offrestages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching offrestages
	 */
	@Override
	public List<Offrestage> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Offrestage> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Offrestage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offrestage> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Offrestage> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Offrestage> orderByComparator,
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

		List<Offrestage> list = null;

		if (useFinderCache) {
			list = (List<Offrestage>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Offrestage offrestage : list) {
					if (!uuid.equals(offrestage.getUuid())) {
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

			sb.append(_SQL_SELECT_OFFRESTAGE_WHERE);

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
				sb.append(OffrestageModelImpl.ORDER_BY_JPQL);
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

				list = (List<Offrestage>)QueryUtil.list(
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
	 * Returns the first offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offrestage
	 * @throws NoSuchOffrestageException if a matching offrestage could not be found
	 */
	@Override
	public Offrestage findByUuid_First(
			String uuid, OrderByComparator<Offrestage> orderByComparator)
		throws NoSuchOffrestageException {

		Offrestage offrestage = fetchByUuid_First(uuid, orderByComparator);

		if (offrestage != null) {
			return offrestage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOffrestageException(sb.toString());
	}

	/**
	 * Returns the first offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching offrestage, or <code>null</code> if a matching offrestage could not be found
	 */
	@Override
	public Offrestage fetchByUuid_First(
		String uuid, OrderByComparator<Offrestage> orderByComparator) {

		List<Offrestage> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offrestage
	 * @throws NoSuchOffrestageException if a matching offrestage could not be found
	 */
	@Override
	public Offrestage findByUuid_Last(
			String uuid, OrderByComparator<Offrestage> orderByComparator)
		throws NoSuchOffrestageException {

		Offrestage offrestage = fetchByUuid_Last(uuid, orderByComparator);

		if (offrestage != null) {
			return offrestage;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchOffrestageException(sb.toString());
	}

	/**
	 * Returns the last offrestage in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching offrestage, or <code>null</code> if a matching offrestage could not be found
	 */
	@Override
	public Offrestage fetchByUuid_Last(
		String uuid, OrderByComparator<Offrestage> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Offrestage> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Offrestage[] findByUuid_PrevAndNext(
			long stageId, String uuid,
			OrderByComparator<Offrestage> orderByComparator)
		throws NoSuchOffrestageException {

		uuid = Objects.toString(uuid, "");

		Offrestage offrestage = findByPrimaryKey(stageId);

		Session session = null;

		try {
			session = openSession();

			Offrestage[] array = new OffrestageImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, offrestage, uuid, orderByComparator, true);

			array[1] = offrestage;

			array[2] = getByUuid_PrevAndNext(
				session, offrestage, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Offrestage getByUuid_PrevAndNext(
		Session session, Offrestage offrestage, String uuid,
		OrderByComparator<Offrestage> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_OFFRESTAGE_WHERE);

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
			sb.append(OffrestageModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(offrestage)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Offrestage> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the offrestages where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Offrestage offrestage :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(offrestage);
		}
	}

	/**
	 * Returns the number of offrestages where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching offrestages
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_OFFRESTAGE_WHERE);

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
		"offrestage.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(offrestage.uuid IS NULL OR offrestage.uuid = '')";

	public OffrestagePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Offrestage.class);

		setModelImplClass(OffrestageImpl.class);
		setModelPKClass(long.class);

		setTable(OffrestageTable.INSTANCE);
	}

	/**
	 * Caches the offrestage in the entity cache if it is enabled.
	 *
	 * @param offrestage the offrestage
	 */
	@Override
	public void cacheResult(Offrestage offrestage) {
		entityCache.putResult(
			OffrestageImpl.class, offrestage.getPrimaryKey(), offrestage);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the offrestages in the entity cache if it is enabled.
	 *
	 * @param offrestages the offrestages
	 */
	@Override
	public void cacheResult(List<Offrestage> offrestages) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (offrestages.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Offrestage offrestage : offrestages) {
			if (entityCache.getResult(
					OffrestageImpl.class, offrestage.getPrimaryKey()) == null) {

				cacheResult(offrestage);
			}
		}
	}

	/**
	 * Clears the cache for all offrestages.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(OffrestageImpl.class);

		finderCache.clearCache(OffrestageImpl.class);
	}

	/**
	 * Clears the cache for the offrestage.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Offrestage offrestage) {
		entityCache.removeResult(OffrestageImpl.class, offrestage);
	}

	@Override
	public void clearCache(List<Offrestage> offrestages) {
		for (Offrestage offrestage : offrestages) {
			entityCache.removeResult(OffrestageImpl.class, offrestage);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(OffrestageImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(OffrestageImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new offrestage with the primary key. Does not add the offrestage to the database.
	 *
	 * @param stageId the primary key for the new offrestage
	 * @return the new offrestage
	 */
	@Override
	public Offrestage create(long stageId) {
		Offrestage offrestage = new OffrestageImpl();

		offrestage.setNew(true);
		offrestage.setPrimaryKey(stageId);

		String uuid = PortalUUIDUtil.generate();

		offrestage.setUuid(uuid);

		return offrestage;
	}

	/**
	 * Removes the offrestage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage that was removed
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	@Override
	public Offrestage remove(long stageId) throws NoSuchOffrestageException {
		return remove((Serializable)stageId);
	}

	/**
	 * Removes the offrestage with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the offrestage
	 * @return the offrestage that was removed
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	@Override
	public Offrestage remove(Serializable primaryKey)
		throws NoSuchOffrestageException {

		Session session = null;

		try {
			session = openSession();

			Offrestage offrestage = (Offrestage)session.get(
				OffrestageImpl.class, primaryKey);

			if (offrestage == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOffrestageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(offrestage);
		}
		catch (NoSuchOffrestageException noSuchEntityException) {
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
	protected Offrestage removeImpl(Offrestage offrestage) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(offrestage)) {
				offrestage = (Offrestage)session.get(
					OffrestageImpl.class, offrestage.getPrimaryKeyObj());
			}

			if (offrestage != null) {
				session.delete(offrestage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (offrestage != null) {
			clearCache(offrestage);
		}

		return offrestage;
	}

	@Override
	public Offrestage updateImpl(Offrestage offrestage) {
		boolean isNew = offrestage.isNew();

		if (!(offrestage instanceof OffrestageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(offrestage.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(offrestage);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in offrestage proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Offrestage implementation " +
					offrestage.getClass());
		}

		OffrestageModelImpl offrestageModelImpl =
			(OffrestageModelImpl)offrestage;

		if (Validator.isNull(offrestage.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			offrestage.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(offrestage);
			}
			else {
				offrestage = (Offrestage)session.merge(offrestage);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			OffrestageImpl.class, offrestageModelImpl, false, true);

		if (isNew) {
			offrestage.setNew(false);
		}

		offrestage.resetOriginalValues();

		return offrestage;
	}

	/**
	 * Returns the offrestage with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the offrestage
	 * @return the offrestage
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	@Override
	public Offrestage findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOffrestageException {

		Offrestage offrestage = fetchByPrimaryKey(primaryKey);

		if (offrestage == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOffrestageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return offrestage;
	}

	/**
	 * Returns the offrestage with the primary key or throws a <code>NoSuchOffrestageException</code> if it could not be found.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage
	 * @throws NoSuchOffrestageException if a offrestage with the primary key could not be found
	 */
	@Override
	public Offrestage findByPrimaryKey(long stageId)
		throws NoSuchOffrestageException {

		return findByPrimaryKey((Serializable)stageId);
	}

	/**
	 * Returns the offrestage with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stageId the primary key of the offrestage
	 * @return the offrestage, or <code>null</code> if a offrestage with the primary key could not be found
	 */
	@Override
	public Offrestage fetchByPrimaryKey(long stageId) {
		return fetchByPrimaryKey((Serializable)stageId);
	}

	/**
	 * Returns all the offrestages.
	 *
	 * @return the offrestages
	 */
	@Override
	public List<Offrestage> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Offrestage> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Offrestage> findAll(
		int start, int end, OrderByComparator<Offrestage> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Offrestage> findAll(
		int start, int end, OrderByComparator<Offrestage> orderByComparator,
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

		List<Offrestage> list = null;

		if (useFinderCache) {
			list = (List<Offrestage>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_OFFRESTAGE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_OFFRESTAGE;

				sql = sql.concat(OffrestageModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Offrestage>)QueryUtil.list(
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
	 * Removes all the offrestages from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Offrestage offrestage : findAll()) {
			remove(offrestage);
		}
	}

	/**
	 * Returns the number of offrestages.
	 *
	 * @return the number of offrestages
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_OFFRESTAGE);

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
		return "stageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_OFFRESTAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return OffrestageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the offrestage persistence.
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

		OffrestageUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		OffrestageUtil.setPersistence(null);

		entityCache.removeCache(OffrestageImpl.class.getName());
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

	private static final String _SQL_SELECT_OFFRESTAGE =
		"SELECT offrestage FROM Offrestage offrestage";

	private static final String _SQL_SELECT_OFFRESTAGE_WHERE =
		"SELECT offrestage FROM Offrestage offrestage WHERE ";

	private static final String _SQL_COUNT_OFFRESTAGE =
		"SELECT COUNT(offrestage) FROM Offrestage offrestage";

	private static final String _SQL_COUNT_OFFRESTAGE_WHERE =
		"SELECT COUNT(offrestage) FROM Offrestage offrestage WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "offrestage.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Offrestage exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Offrestage exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		OffrestagePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}