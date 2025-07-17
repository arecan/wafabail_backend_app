/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package article.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;WAFABAIL_Article&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Article
 * @generated
 */
public class ArticleTable extends BaseTable<ArticleTable> {

	public static final ArticleTable INSTANCE = new ArticleTable();

	public final Column<ArticleTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, Long> articleId = createColumn(
		"articleId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ArticleTable, String> titre = createColumn(
		"titre", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, String> detail = createColumn(
		"detail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ArticleTable, Date> dateCreation = createColumn(
		"dateCreation", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private ArticleTable() {
		super("WAFABAIL_Article", ArticleTable::new);
	}

}