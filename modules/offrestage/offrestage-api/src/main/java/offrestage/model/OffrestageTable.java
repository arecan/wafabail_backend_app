/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;WAFABAIL_Offrestage&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Offrestage
 * @generated
 */
public class OffrestageTable extends BaseTable<OffrestageTable> {

	public static final OffrestageTable INSTANCE = new OffrestageTable();

	public final Column<OffrestageTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OffrestageTable, Long> stageId = createColumn(
		"stageId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OffrestageTable, String> titre = createColumn(
		"titre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OffrestageTable, String> detail = createColumn(
		"detail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OffrestageTable, Date> dateCreation = createColumn(
		"dateCreation", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private OffrestageTable() {
		super("WAFABAIL_Offrestage", OffrestageTable::new);
	}

}