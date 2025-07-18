package publicationsrest.application;


import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.liferay.document.library.kernel.service.DLAppServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;

import dto.ArticleDto;
import dto.PublicationDto;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;
import services.ArticleService;


/**
 * @author Arecan
 */
@Component(
	property = {
		JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/wafabail",
		JaxrsWhiteboardConstants.JAX_RS_NAME + "=publications.Rest"
	},
	service = Application.class
)
public class PublicationsRestApplication extends Application {

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
	private ArticleService articleService;



/*	@Context
	private HttpServletRequest request;

	private long getGroupIdFromRequest() {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		if (themeDisplay != null) {
			return themeDisplay.getScopeGroupId();
		}
		return 0L;
	}*/

	@GET
	@Path("/getPublications")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPublications() {
		Map<String, List<PublicationDto>> categorizedPublications = new HashMap<>();


		long groupId = 20119;
		long repositoryId = groupId;
		long parentFolderId = 0;

		String mainFolderName = "wafabailPublication"; // dossier racine
		String[] subFolders = { "Publications Financieres", "Rapports Annuels", "Autres rapports" };

		try {
			// Récupère le dossier principal
			Folder mainFolder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, mainFolderName);
			long mainFolderId = mainFolder.getFolderId();

			for (String subFolderName : subFolders) {
				List<PublicationDto> publications = new ArrayList<>();

				// Récupère chaque sous-dossier
				Folder subFolder = DLAppServiceUtil.getFolder(repositoryId, mainFolderId, subFolderName);
				long subFolderId = subFolder.getFolderId();

				// Récupère les fichiers du sous-dossier
				List<FileEntry> files = DLAppServiceUtil.getFileEntries(groupId, subFolderId, -1, -1);

				for (FileEntry file : files) {
					String title = file.getTitle();
					String url = "/documents/" + groupId + "/" + subFolderId + "/" +
							file.getFileName() + "/" + file.getUuid() + "?version=1.0";

					publications.add(new PublicationDto(title, url));
				}


				categorizedPublications.put(subFolderName, publications);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		return Response.ok(categorizedPublications).build();
	}

	@GET
	@Path("/articles/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticle(@PathParam("id") long articleId) {
		try {
			ArticleDto article = articleService.getArticle(articleId);
			return Response.ok(article).build();
		} catch (PortalException e) {
			return Response.status(Response.Status.NOT_FOUND).entity("Article non trouvé").build();
		}
	}

	@GET
	@Path("/articles")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllArticles() {
		try {
			List<ArticleDto> articles = articleService.getAllArticles();
			return Response.ok(articles).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@GET
	@Path("/articles/paginated")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPaginatedArticles(@QueryParam("start") @DefaultValue("0") int start,
										 @QueryParam("end") @DefaultValue("10") int end) {
		try {
			List<ArticleDto> articles = articleService.getArticles(start, end);
			return Response.ok(articles).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}


}