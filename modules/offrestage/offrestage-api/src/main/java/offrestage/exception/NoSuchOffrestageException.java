/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package offrestage.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchOffrestageException extends NoSuchModelException {

	public NoSuchOffrestageException() {
	}

	public NoSuchOffrestageException(String msg) {
		super(msg);
	}

	public NoSuchOffrestageException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchOffrestageException(Throwable throwable) {
		super(throwable);
	}

}