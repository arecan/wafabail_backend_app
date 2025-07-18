package offrestagerest.application;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.liferay.portal.kernel.exception.PortalException;
import dto.OffrestageDto;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import services.OffreStageService;
import wafabailrest.application.CorsFilter;

/**
 * @author Arecan
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/offrestages",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=Offrestages.Rest"
	},
	service = Application.class
)
public class OffrestageRestApplication extends Application {

	@Reference
	private OffreStageService stageService;

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(CorsFilter.class);
		return classes;
	}


	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}


	// --- STAGES ---
	@GET
	@Path("/stages/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStage(@PathParam("id") long stageId) {
		try {
			OffrestageDto stage = stageService.getStage(stageId);
			return Response.ok(stage).build();
		} catch (PortalException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Stage non trouvé").build();
		}
	}

	@GET
	@Path("/stages")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllStages() {
		try {
			List<OffrestageDto> stages = stageService.getAllStages();
			return Response.ok(stages).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/stages/paginated")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaginatedStages(@QueryParam("start") @DefaultValue("0") int start,
									   @QueryParam("end") @DefaultValue("10") int end) {
		try {
			List<OffrestageDto> stages = stageService.getStages(start, end);
			return Response.ok(stages).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}