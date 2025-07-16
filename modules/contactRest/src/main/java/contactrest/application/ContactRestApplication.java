package contactrest.application;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dtos.ContactDto;
import dtos.EmailDto;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import services.EmailingService;

/**
 * @author Arecan
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/contact",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=contact.Rest"
	},
	service = Application.class
)
public class ContactRestApplication extends Application {

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
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@Reference
	private EmailingService emailingService;

	@POST
	@Path("/sendEmail")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response envoyerEmail(EmailDto emailDto) {
		try {
			emailingService.envoyerEmail(emailDto);
			return Response.ok("Email envoyé avec succès").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().entity("Erreur lors de l'envoi de l'email").build();
		}
	}

	@POST
	@Path("/sendContact")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response envoyerContact(ContactDto contactDto) {
		try {
			emailingService.envoyerContact(contactDto);
			return Response.ok("Contact envoyé avec succès").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().entity("Erreur lors de l'envoi du contact").build();
		}
	}

}