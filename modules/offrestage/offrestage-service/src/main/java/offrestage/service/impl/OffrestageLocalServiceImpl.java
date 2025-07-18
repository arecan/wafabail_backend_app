/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package offrestage.service.impl;

import com.liferay.portal.aop.AopService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import offrestage.model.Offrestage;
import offrestage.service.base.OffrestageLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=offrestage.model.Offrestage",
	service = AopService.class
)
public class OffrestageLocalServiceImpl extends OffrestageLocalServiceBaseImpl {
	private static final Log _log = LogFactoryUtil.getLog(OffrestageLocalServiceImpl.class);

	// Ajouter un stage
	public Offrestage addStage(String titre, String detail) {
		try {
			long stageId = counterLocalService.increment(Offrestage.class.getName());
			Offrestage stage = offrestagePersistence.create(stageId);

			stage.setUuid(UUID.randomUUID().toString());
			stage.setTitre(titre);
			stage.setDetail(detail);
			stage.setDateCreation(new Date());

			stage = offrestagePersistence.update(stage);

			_log.info("Stage créé avec l'ID: " + stageId);

			return stage;
		} catch (Exception e) {
			_log.error("Erreur lors de la création du stage", e);
			throw new RuntimeException("Impossible de créer le stage", e);
		}
	}

	// Mettre à jour un stage
	public Offrestage updateStage(long stageId, String titre, String detail) throws PortalException {
		try {
			Offrestage stage = offrestagePersistence.findByPrimaryKey(stageId);

			if (stage == null) {
				throw new PortalException("Stage introuvable avec l'ID: " + stageId);
			}

			stage.setTitre(titre);
			stage.setDetail(detail);

			stage = offrestagePersistence.update(stage);

			_log.info("Stage modifié avec l'ID: " + stageId);

			return stage;
		} catch (Exception e) {
			_log.error("Erreur lors de la mise à jour du stage avec l'ID: " + stageId, e);
			throw new PortalException("Impossible de modifier le stage avec l'ID: " + stageId, e);
		}
	}

	// Récupérer un stage par son ID
	public Offrestage getStage(long stageId) throws PortalException {
		try {
			Offrestage stage = offrestagePersistence.findByPrimaryKey(stageId);

			_log.info("Stage récupéré avec l'ID: " + stageId);

			return stage;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération du stage avec l'ID: " + stageId, e);
			throw new PortalException("Impossible de récupérer le stage avec l'ID: " + stageId, e);
		}
	}

	// Récupérer tous les stages
	public List<Offrestage> getAllStages() {
		try {
			List<Offrestage> stages = offrestagePersistence.findAll();

			_log.info("Tous les stages ont été récupérés. Total: " + stages.size());

			return stages;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération des stages", e);
			throw new RuntimeException("Impossible de récupérer la liste des stages", e);
		}
	}

	// Récupérer les stages paginés
	public List<Offrestage> getStages(int start, int end) {
		try {
			List<Offrestage> stages = offrestagePersistence.findAll(start, end);

			_log.info("Stages paginés récupérés de " + start + " à " + end + ". Total retourné: " + stages.size());

			return stages;
		} catch (Exception e) {
			_log.error("Erreur lors de la récupération paginée des stages", e);
			throw new RuntimeException("Impossible de récupérer la liste paginée des stages", e);
		}
	}

	// Supprimer un stage
	public Offrestage deleteStage(long stageId) throws PortalException {
		try {
			Offrestage stage = offrestagePersistence.findByPrimaryKey(stageId);

			if (stage == null) {
				throw new PortalException("Stage introuvable avec l'ID: " + stageId);
			}

			stage = offrestagePersistence.remove(stage);

			_log.info("Stage supprimé avec l'ID: " + stageId);

			return stage;
		} catch (Exception e) {
			_log.error("Erreur lors de la suppression du stage avec l'ID: " + stageId, e);
			throw new PortalException("Impossible de supprimer le stage avec l'ID: " + stageId, e);
		}
	}
}