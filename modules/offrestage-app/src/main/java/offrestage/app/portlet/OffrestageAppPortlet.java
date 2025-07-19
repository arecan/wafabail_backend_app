package offrestage.app.portlet;

import com.liferay.portal.kernel.util.ParamUtil;
import offrestage.app.constants.OffrestageAppPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import offrestage.model.Offrestage;
import offrestage.service.OffrestageLocalService;
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
		"javax.portlet.display-name=OffrestageApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OffrestageAppPortletKeys.OFFRESTAGEAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OffrestageAppPortlet extends MVCPortlet {

	@Reference
	private OffrestageLocalService offrestageLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Offrestage> stages = offrestageLocalService.getOffrestages(-1, -1);
		renderRequest.setAttribute("offrestages", stages);
		super.doView(renderRequest, renderResponse);
	}

	public void navigateToAddPage(ActionRequest request, ActionResponse response) {
		response.getRenderParameters().setValue("mvcPath", "/add.jsp");
	}

	public void add(ActionRequest request, ActionResponse response) {
		String titre = ParamUtil.getString(request, "titre");
		String detail = ParamUtil.getString(request, "detail");

		try {
			offrestageLocalService.addStage(titre,detail);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			response.getRenderParameters().setValue("mvcPath", "/add.jsp");
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}

	public void display(ActionRequest request, ActionResponse response) throws Exception {
		long stageId = ParamUtil.getLong(request, "stageId");
		Offrestage stage = offrestageLocalService.getStage(stageId);
		request.setAttribute("offrestage", stage);
		response.getRenderParameters().setValue("mvcPath", "/display.jsp");
	}

	public void delete(ActionRequest request, ActionResponse response) throws Exception {
		long stageId = ParamUtil.getLong(request, "stageId");
		offrestageLocalService.deleteOffrestage(stageId);
		response.getRenderParameters().setValue("mvcPath", "/view.jsp");
	}

	public void navigateToEditPage(ActionRequest request, ActionResponse response) throws Exception {
		long stageId = ParamUtil.getLong(request, "stageId");
		Offrestage stage = offrestageLocalService.getStage(stageId);
		request.setAttribute("offrestage", stage);
		response.getRenderParameters().setValue("mvcPath", "/update.jsp");
	}

	public void update(ActionRequest request, ActionResponse response) throws Exception {
		long stageId = ParamUtil.getLong(request, "stageId");
		String titre = ParamUtil.getString(request, "titre");
		String detail = ParamUtil.getString(request, "detail");

		try {
			offrestageLocalService.updateStage(stageId,titre,detail);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			request.setAttribute("offrestage", offrestageLocalService.getOffrestage(stageId));
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}
}