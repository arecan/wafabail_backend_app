package services;

import com.liferay.portal.kernel.exception.PortalException;
import dto.OffrestageDto;

import java.util.List;

public interface OffreStageService {
    OffrestageDto getStage(long stageId) throws PortalException;

    List<OffrestageDto> getAllStages();

    List<OffrestageDto> getStages(int start, int end);
}
