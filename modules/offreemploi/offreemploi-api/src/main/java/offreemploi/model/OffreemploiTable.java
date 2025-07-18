/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;WAFABAIL_Offreemploi&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Offreemploi
 * @generated
 */
public class OffreemploiTable extends BaseTable<OffreemploiTable> {

	public static final OffreemploiTable INSTANCE = new OffreemploiTable();

	public final Column<OffreemploiTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OffreemploiTable, Long> OffreemploiId = createColumn(
		"OffreemploiId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<OffreemploiTable, String> titre = createColumn(
		"titre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OffreemploiTable, String> detail = createColumn(
		"detail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<OffreemploiTable, Date> dateCreation = createColumn(
		"dateCreation", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private OffreemploiTable() {
		super("WAFABAIL_Offreemploi", OffreemploiTable::new);
	}

}