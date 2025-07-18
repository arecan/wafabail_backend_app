package wafabailrest.application;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.liferay.portal.kernel.exception.PortalException;
import dto.RevueDto;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import services.RevueService;

/**
 * @author Arecan
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/revuespresse",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=wafabail.Rest"
	},
	service = Application.class
)
public class WafabailRestApplication extends Application {


	@Reference
	private RevueService revueService;



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



	// --- REVUES ---

	@GET
	@Path("/revues/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRevue(@PathParam("id") long revueId) {
		try {
			RevueDto revue = revueService.getRevue(revueId);
			return Response.ok(revue).build();
		} catch (PortalException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Revue non trouvée").build();
		}
	}

	@GET
	@Path("/revues")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRevues() {
		try {
			List<RevueDto> revues = revueService.getAllRevues();
			return Response.ok(revues).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/revues/paginated")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaginatedRevues(@QueryParam("start") @DefaultValue("0") int start,
									   @QueryParam("end") @DefaultValue("10") int end) {
		try {
			List<RevueDto> revues = revueService.getRevues(start, end);
			return Response.ok(revues).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}