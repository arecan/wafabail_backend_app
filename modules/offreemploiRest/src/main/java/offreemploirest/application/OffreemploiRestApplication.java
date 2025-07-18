package offreemploirest.application;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.liferay.portal.kernel.exception.PortalException;
import dto.OffreemploiDto;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import services.OffreemploiService;
import wafabailrest.application.CorsFilter;

/**
 * @author Arecan
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/offreemplois",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=emplois.Rest"
	},
	service = Application.class
)
public class OffreemploiRestApplication extends Application {

	@Reference
	private OffreemploiService offreemploiService;

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


// --- OFFREEMPLOIS ---

	@GET
	@Path("/emplois/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOffreemploi(@PathParam("id") long offreemploiId) {
		try {
			OffreemploiDto offreemploi = offreemploiService.getOffreemploi(offreemploiId);
			return Response.ok(offreemploi).build();
		} catch (PortalException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Offre d'emploi non trouvée").build();
		}
	}

	@GET
	@Path("/emplois")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllOffreemplois() {
		try {
			List<OffreemploiDto> offreemplois = offreemploiService.getAllOffreemplois();
			return Response.ok(offreemplois).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@GET
	@Path("/emplois/paginated")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaginatedOffreemplois(@QueryParam("start") @DefaultValue("0") int start,
											 @QueryParam("end") @DefaultValue("10") int end) {
		try {
			List<OffreemploiDto> offreemplois = offreemploiService.getOffreemplois(start, end);
			return Response.ok(offreemplois).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

	}
}