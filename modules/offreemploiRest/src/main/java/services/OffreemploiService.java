package services;

import com.liferay.portal.kernel.exception.PortalException;
import dto.OffreemploiDto;

import java.util.List;

public interface OffreemploiService {

    OffreemploiDto getOffreemploi(long offreemploiId) throws PortalException;

    List<OffreemploiDto> getAllOffreemplois();

    List<OffreemploiDto> getOffreemplois(int start, int end);
}
