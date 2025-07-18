package services.impl;


import com.liferay.portal.kernel.exception.PortalException;
import dto.OffreemploiDto;
import offreemploi.model.Offreemploi;
import offreemploi.service.OffreemploiLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import services.OffreemploiService;

import java.util.List;
import java.util.stream.Collectors;

@Component(
        service = {OffreemploiServiceImpl.class, OffreemploiService.class}
)
public class OffreemploiServiceImpl implements OffreemploiService {

    private OffreemploiDto toDto(Offreemploi offre) {
        if (offre == null) return null;
        return new OffreemploiDto(
                offre.getOffreemploiId(),
                offre.getTitre(),
                offre.getDetail(),
                offre.getDateCreation()
        );
    }

    private List<OffreemploiDto> toDtoList(List<Offreemploi> offres) {
        return offres.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public OffreemploiDto getOffreemploi(long offreemploiId) throws PortalException {
        return toDto(OffreemploiLocalServiceUtil.getOffreemploi(offreemploiId));
    }

    @Override
    public List<OffreemploiDto> getAllOffreemplois() {
        return toDtoList(OffreemploiLocalServiceUtil.getAllOffreemplois());
    }

    @Override
    public List<OffreemploiDto> getOffreemplois(int start, int end) {
        return toDtoList(OffreemploiLocalServiceUtil.getOffreemplois(start, end));
    }


}
