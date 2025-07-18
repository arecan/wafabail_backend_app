package services.impl;

import com.liferay.portal.kernel.exception.PortalException;
import dto.OffrestageDto;
import offrestage.model.Offrestage;
import offrestage.service.OffrestageLocalServiceUtil;
import org.osgi.service.component.annotations.Component;
import services.OffreStageService;

import java.util.List;
import java.util.stream.Collectors;
@Component(
        service = {OffrestageServiceImpl.class, OffreStageService.class}
)
public class OffrestageServiceImpl implements OffreStageService {

    private OffrestageDto toDto(Offrestage offre) {
        if (offre == null) return null;
        return new OffrestageDto(
                offre.getStageId(),
                offre.getTitre(),
                offre.getDetail(),
                offre.getDateCreation()
        );
    }

    private List<OffrestageDto> toDtoList(List<Offrestage> offres) {
        return offres.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public OffrestageDto getStage(long offrestageId) throws PortalException {
        return toDto(OffrestageLocalServiceUtil.getOffrestage(offrestageId));
    }

    @Override
    public List<OffrestageDto> getAllStages() {
        return toDtoList(OffrestageLocalServiceUtil.getAllStages());
    }

    @Override
    public List<OffrestageDto> getStages(int start, int end) {
        return toDtoList(OffrestageLocalServiceUtil.getOffrestages(start, end));
    }
}
