package offreemploi.app.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import offreemploi.app.constants.OffreemploiAppPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import offreemploi.model.Offreemploi;
import offreemploi.service.OffreemploiLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.List;

/**
 * @author Arecan
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OffreemploiApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OffreemploiAppPortletKeys.OFFREEMPLOIAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OffreemploiAppPortlet extends MVCPortlet {

	@Reference
	private OffreemploiLocalService offreemploiLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Offreemploi> emplois = offreemploiLocalService.getOffreemplois(-1, -1);
		renderRequest.setAttribute("offreemplois", emplois);
		super.doView(renderRequest, renderResponse);
	}

	public void navigateToAddPage(ActionRequest request, ActionResponse response) {
		response.getRenderParameters().setValue("mvcPath", "/META-INF/resources/add.jsp");
	}

	public void add(ActionRequest request, ActionResponse response) {
		String titre = ParamUtil.getString(request, "titre");
		String detail = ParamUtil.getString(request, "detail");

		try {
			offreemploiLocalService.addOffreemploi(titre, detail);
			response.setRenderParameter("mvcPath", "/view.jsp");
		} catch (Exception e) {
			response.getRenderParameters().setValue("mvcPath", "/META-INF/resources/add.jsp");
		}
	}

	public void display(ActionRequest request, ActionResponse response) throws Exception {
		long offreemploiId = ParamUtil.getLong(request, "offreemploiId");
		Offreemploi emploi = offreemploiLocalService.getOffreemploi(offreemploiId);
		request.setAttribute("offreemploi", emploi);
		response.getRenderParameters().setValue("mvcPath", "/display.jsp");
	}

	public void delete(ActionRequest request, ActionResponse response) throws Exception {
		long offreemploiId = ParamUtil.getLong(request, "offreemploiId");
		offreemploiLocalService.deleteOffreemploi(offreemploiId);
		response.getRenderParameters().setValue("mvcPath", "/view.jsp");
	}

	public void navigateToEditPage(ActionRequest request, ActionResponse response) throws Exception {
		long offreemploiId = ParamUtil.getLong(request, "offreemploiId");
		Offreemploi emploi = offreemploiLocalService.getOffreemploi(offreemploiId);
		request.setAttribute("offreemploi", emploi);
		response.getRenderParameters().setValue("mvcPath", "/update.jsp");
	}

	public void update(ActionRequest request, ActionResponse response) throws Exception {
		long offreemploiId = ParamUtil.getLong(request, "offreemploiId");
		String titre = ParamUtil.getString(request, "titre");
		String detail = ParamUtil.getString(request, "detail");

		try {
			offreemploiLocalService.updateOffreemploi(offreemploiId, titre, detail);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			request.setAttribute("offreemploi", offreemploiLocalService.getOffreemploi(offreemploiId));
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}
}