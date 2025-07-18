/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.service.impl;

import com.liferay.portal.aop.AopService;

import offrestage.service.base.OffrestageServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=wafabail",
		"json.web.service.context.path=Offrestage"
	},
	service = AopService.class
)
public class OffrestageServiceImpl extends OffrestageServiceBaseImpl {
}