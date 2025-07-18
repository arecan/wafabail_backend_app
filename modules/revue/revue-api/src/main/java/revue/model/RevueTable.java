/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;WAFABAIL_Revue&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Revue
 * @generated
 */
public class RevueTable extends BaseTable<RevueTable> {

	public static final RevueTable INSTANCE = new RevueTable();

	public final Column<RevueTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RevueTable, Long> revueId = createColumn(
		"revueId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<RevueTable, String> titre = createColumn(
		"titre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RevueTable, String> details = createColumn(
		"details", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RevueTable, String> lien = createColumn(
		"lien", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<RevueTable, Date> dateCreation = createColumn(
		"dateCreation", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private RevueTable() {
		super("WAFABAIL_Revue", RevueTable::new);
	}

}