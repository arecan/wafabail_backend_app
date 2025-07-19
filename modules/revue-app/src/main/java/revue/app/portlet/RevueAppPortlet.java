package revue.app.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Reference;
import revue.app.constants.RevueAppPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import org.osgi.service.component.annotations.Component;
import revue.model.Revue;
import revue.service.RevueLocalService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Arecan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=RevueApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + RevueAppPortletKeys.REVUEAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class RevueAppPortlet extends MVCPortlet {
	@Reference
	private RevueLocalService revueLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Revue> revues = revueLocalService.getRevues(-1, -1);
		renderRequest.setAttribute("revues", revues);
		super.doView(renderRequest, renderResponse);
	}

	public void navigateToAddPage(ActionRequest request, ActionResponse response) {
		response.getRenderParameters().setValue("mvcPath", "/add.jsp");
	}

	public void add(ActionRequest request, ActionResponse response) {
		String titre = ParamUtil.getString(request, "titre");
		String details = ParamUtil.getString(request, "details");
		String lien = ParamUtil.getString(request, "lien");

		try {
			revueLocalService.addRevue(titre, details, lien);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			response.getRenderParameters().setValue("mvcPath", "/add.jsp");
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}
	public void ajouter(ActionRequest request, ActionResponse response) {
		String titre = ParamUtil.getString(request, "titre");
		String details = ParamUtil.getString(request, "details");
		String lien = ParamUtil.getString(request, "lien");
		String dateStr = ParamUtil.getString(request, "dateCreation");
		Date dateCreation = null;
		try {
			dateCreation = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			revueLocalService.ajouterRevue(titre, details, lien,dateCreation);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			response.getRenderParameters().setValue("mvcPath", "/add.jsp");
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}

	public void display(ActionRequest request, ActionResponse response) throws Exception {
		long revueId = ParamUtil.getLong(request, "revueId");
		if (revueId > 0) {
			Revue revue = revueLocalService.getRevue(revueId);
			request.setAttribute("revue", revue);
			response.getRenderParameters().setValue("mvcPath", "/display.jsp");
		}
	}

	public void delete(ActionRequest request, ActionResponse response) throws Exception {
		long revueId = ParamUtil.getLong(request, "revueId");
		revueLocalService.deleteRevue(revueId);
		response.getRenderParameters().setValue("mvcPath", "/view.jsp");
	}

	public void navigateToEditPage(ActionRequest request, ActionResponse response) throws Exception {
		long revueId = ParamUtil.getLong(request, "revueId");
		Revue revue = revueLocalService.getRevue(revueId);
		request.setAttribute("revue", revue);
		response.getRenderParameters().setValue("mvcPath", "/update.jsp");
	}

	public void update(ActionRequest request, ActionResponse response) throws Exception {
		long revueId = ParamUtil.getLong(request, "revueId");
		String titre = ParamUtil.getString(request, "titre");
		String details = ParamUtil.getString(request, "details");
		String lien = ParamUtil.getString(request, "lien");

		try {
			revueLocalService.updateRevue(revueId, titre, details, lien);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			request.setAttribute("revue", revueLocalService.getRevue(revueId));
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}
	public void modifier(ActionRequest request, ActionResponse response) throws Exception {
		long revueId = ParamUtil.getLong(request, "revueId");
		String titre = ParamUtil.getString(request, "titre");
		String details = ParamUtil.getString(request, "details");
		String lien = ParamUtil.getString(request, "lien");
		String dateStr = ParamUtil.getString(request, "dateCreation");
		Date dateCreation = null;
		try {
			dateCreation = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			revueLocalService.modifierRevue(revueId, titre, details, lien,dateCreation);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			request.setAttribute("revue", revueLocalService.getRevue(revueId));
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}
}