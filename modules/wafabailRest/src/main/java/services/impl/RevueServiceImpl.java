package services.impl;

import com.liferay.portal.kernel.exception.PortalException;
import dto.RevueDto;
import org.osgi.service.component.annotations.Component;
import revue.service.RevueLocalServiceUtil;
import services.RevueService;
import revue.model.Revue;

import java.util.List;
import java.util.stream.Collectors;

@Component(
        service = {RevueServiceImpl.class, RevueService.class}
)
public class RevueServiceImpl implements RevueService {

    private RevueDto toDto(Revue revue) {
        if (revue == null) return null;
        return new RevueDto(
                revue.getRevueId(),
                revue.getTitre(),
                revue.getDetails(),
                revue.getLien(),
                revue.getDateCreation()
        );
    }

    private List<RevueDto> toDtoList(List<Revue> revues) {
        return revues.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public RevueDto getRevue(long revueId) throws PortalException {
        return toDto(RevueLocalServiceUtil.getRevue(revueId));
    }

    @Override
    public List<RevueDto> getAllRevues() {
        return toDtoList(RevueLocalServiceUtil.getAllRevues());
    }

    @Override
    public List<RevueDto> getRevues(int start, int end) {
        return toDtoList(RevueLocalServiceUtil.getRevues(start, end));
    }
}
