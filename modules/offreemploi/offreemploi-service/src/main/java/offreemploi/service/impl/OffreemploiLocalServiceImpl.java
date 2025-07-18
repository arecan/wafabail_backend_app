/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offreemploi.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

import offreemploi.model.Offreemploi;
import offreemploi.service.base.OffreemploiLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
		property = "model.class.name=offreemploi.model.Offreemploi",
		service = AopService.class
)
public class OffreemploiLocalServiceImpl extends OffreemploiLocalServiceBaseImpl {

	private static final Log _log = LogFactoryUtil.getLog(OffreemploiLocalServiceImpl.class);

	// Ajouter une offre d'emploi
	public Offreemploi addOffreemploi(String titre, String detail) {
		try {
			long offreemploiId = counterLocalService.increment(Offreemploi.class.getName());
			Offreemploi offreemploi = offreemploiPersistence.create(offreemploiId);

			offreemploi.setUuid(UUID.randomUUID().toString());
			offreemploi.setTitre(titre);
			offreemploi.setDetail(detail);
			offreemploi.setDateCreation(new Date());

			offreemploi = offreemploiPersistence.update(offreemploi);

			_log.info("Offre d'emploi créée avec l'ID: " + offreemploiId);

			return offreemploi;
		} catch (Exception e) {
			_log.error("Erreur lors de la création de l'offre d'emploi", e);
			throw new RuntimeException("Impossible de créer l'offre d'emploi", e);
		}
	}

	// Mettre à jour une offre d'emploi
	public Offreemploi updateOffreemploi(long offreemploiId, String titre, String detail) throws PortalException {
		try {
			Offreemploi offreemploi = offreemploiPersistence.findByPrimaryKey(offreemploiId);

			if (offreemploi == null) {
				throw new PortalException("Offre d'emploi introuvable avec l'ID: " + offreemploiId);
			}

			offreemploi.setTitre(titre);
			offreemploi.setDetail(detail);

			offreemploi = offreemploiPersistence.update(offreemploi);

			_log.info("Offre d'emploi modifiée avec l'ID: " + offreemploiId);

			return offreemploi;
		} catch (Exception e) {
			_log.error("Erreur lors de la mise à jour de l'offre d'emploi avec l'ID: " + offreemploiId, e);
			throw new PortalException("Impossible de modifier l'offre d'emploi avec l'ID: " + offreemploiId, e);
		}
	}

	// Récupérer une offre d'emploi par son ID
	public Offreemploi getOffreemploi(long offreemploiId) throws PortalException {
		try {
			Offreemploi offreemploi = offreemploiPersistence.findByPrimaryKey(offreemploiId);

			_log.info("Offre d'emploi récupérée avec l'ID: " + offreemploiId);

			return offreemploi;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération de l'offre d'emploi avec l'ID: " + offreemploiId, e);
			throw new PortalException("Impossible de récupérer l'offre d'emploi avec l'ID: " + offreemploiId, e);
		}
	}

	// Récupérer toutes les offres d'emploi
	public List<Offreemploi> getAllOffreemplois() {
		try {
			List<Offreemploi> offres = offreemploiPersistence.findAll();

			_log.info("Toutes les offres d'emploi ont été récupérées. Total: " + offres.size());

			return offres;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération des offres d'emploi", e);
			throw new RuntimeException("Impossible de récupérer la liste des offres d'emploi", e);
		}
	}

	// Récupérer les offres paginées
	public List<Offreemploi> getOffreemplois(int start, int end) {
		try {
			List<Offreemploi> offres = offreemploiPersistence.findAll(start, end);

			_log.info("Offres d'emploi paginées récupérées de " + start + " à " + end + ". Total retourné: " + offres.size());

			return offres;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération paginée des offres d'emploi", e);
			throw new RuntimeException("Impossible de récupérer la liste paginée des offres d'emploi", e);
		}
	}

	// Supprimer une offre d'emploi
	public Offreemploi deleteOffreemploi(long offreemploiId) throws PortalException {
		try {
			Offreemploi offreemploi = offreemploiPersistence.findByPrimaryKey(offreemploiId);

			if (offreemploi == null) {
				throw new PortalException("Offre d'emploi introuvable avec l'ID: " + offreemploiId);
			}

			offreemploi = offreemploiPersistence.remove(offreemploi);

			_log.info("Offre d'emploi supprimée avec l'ID: " + offreemploiId);

			return offreemploi;
		} catch (Exception e) {
			_log.error("Erreur lors de la suppression de l'offre d'emploi avec l'ID: " + offreemploiId, e);
			throw new PortalException("Impossible de supprimer l'offre d'emploi avec l'ID: " + offreemploiId, e);
		}
	}
}
