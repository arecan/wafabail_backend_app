package services;

import com.liferay.portal.kernel.exception.PortalException;
import dto.RevueDto;

import java.util.List;

public interface RevueService {

    RevueDto getRevue(long revueId) throws PortalException;

    List<RevueDto> getAllRevues();

    List<RevueDto> getRevues(int start, int end);
}
