/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package revue.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import revue.model.Revue;
import revue.service.base.RevueLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=revue.model.Revue", service = AopService.class
)
public class RevueLocalServiceImpl extends RevueLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(RevueLocalServiceImpl.class);

	public Revue addRevue(String titre, String details, String lien) {
		try {
			long revueId = counterLocalService.increment(Revue.class.getName());
			Revue revue = revuePersistence.create(revueId);

			revue.setUuid(UUID.randomUUID().toString());
			revue.setTitre(titre);
			revue.setDetails(details);
			revue.setLien(lien);
			revue.setDateCreation(new Date());

			revue = revuePersistence.update(revue);

			_log.info("Revue créée avec l'ID: " + revueId);

			return revue;
		} catch (Exception e) {
			_log.error("Erreur lors de la création de la revue", e);
			throw new RuntimeException("Impossible de créer la revue", e);
		}
	}
	public Revue ajouterRevue(String titre, String details, String lien,Date dateCreation) {
		try {
			long revueId = counterLocalService.increment(Revue.class.getName());
			Revue revue = revuePersistence.create(revueId);

			revue.setUuid(UUID.randomUUID().toString());
			revue.setTitre(titre);
			revue.setDetails(details);
			revue.setLien(lien);
			revue.setDateCreation(dateCreation);

			revue = revuePersistence.update(revue);

			_log.info("Revue créée avec l'ID: " + revueId);

			return revue;
		} catch (Exception e) {
			_log.error("Erreur lors de la création de la revue", e);
			throw new RuntimeException("Impossible de créer la revue", e);
		}
	}

	public Revue updateRevue(long revueId, String titre, String details, String lien) throws PortalException {
		try {
			Revue revue = revuePersistence.findByPrimaryKey(revueId);

			if (revue == null) {
				throw new PortalException("Revue introuvable avec l'ID: " + revueId);
			}

			revue.setTitre(titre);
			revue.setDetails(details);
			revue.setLien(lien);

			revue = revuePersistence.update(revue);

			_log.info("Revue modifiée avec l'ID: " + revueId);

			return revue;
		} catch (Exception e) {
			_log.error("Erreur lors de la mise à jour de la revue", e);
			throw new PortalException("Impossible de modifier la revue avec l'ID: " + revueId, e);
		}
	}
	public Revue modifierRevue(long revueId, String titre, String details, String lien,Date dateCreation) throws PortalException {
		try {
			Revue revue = revuePersistence.findByPrimaryKey(revueId);

			if (revue == null) {
				throw new PortalException("Revue introuvable avec l'ID: " + revueId);
			}

			revue.setTitre(titre);
			revue.setDetails(details);
			revue.setLien(lien);
			revue.setDateCreation(dateCreation);

			revue = revuePersistence.update(revue);

			_log.info("Revue modifiée avec l'ID: " + revueId);

			return revue;
		} catch (Exception e) {
			_log.error("Erreur lors de la mise à jour de la revue", e);
			throw new PortalException("Impossible de modifier la revue avec l'ID: " + revueId, e);
		}
	}


	public Revue getRevue(long revueId) throws PortalException {
		try {
			Revue revue = revuePersistence.findByPrimaryKey(revueId);

			_log.info("Revue récupérée avec l'ID: " + revueId);

			return revue;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération de la revue avec l'ID: " + revueId, e);
			throw new PortalException("Impossible de récupérer la revue avec l'ID: " + revueId, e);
		}
	}

	public List<Revue> getAllRevues() {
		try {
			List<Revue> revues = revuePersistence.findAll();

			_log.info("Revues récupérées. Total: " + revues.size());

			return revues;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération des revues", e);
			throw new RuntimeException("Impossible de récupérer la liste des revues", e);
		}
	}

	public List<Revue> getAllRevues(int start, int end) {
		try {
			List<Revue> revues = revuePersistence.findAll(start, end);

			_log.info("Revues paginées récupérées de " + start + " à " + end);

			return revues;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération paginée des revues", e);
			throw new RuntimeException("Impossible de récupérer la liste paginée des revues", e);
		}
	}

	public Revue deleteRevue(long revueId) throws PortalException {
		try {
			Revue revue = revuePersistence.findByPrimaryKey(revueId);

			if (revue == null) {
				throw new PortalException("Revue introuvable avec l'ID: " + revueId);
			}

			revue = revuePersistence.remove(revue);

			_log.info("Revue supprimée avec l'ID: " + revueId);

			return revue;
		} catch (Exception e) {
			_log.error("Erreur lors de la suppression de la revue avec l'ID: " + revueId, e);
			throw new PortalException("Impossible de supprimer la revue avec l'ID: " + revueId, e);
		}
	}

}