package article.app.portlet;

import article.app.constants.ArticleAppPortletKeys;

import article.model.Article;
import article.service.ArticleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
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
		"javax.portlet.display-name=ArticleApp",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ArticleAppPortletKeys.ARTICLEAPP,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ArticleAppPortlet extends MVCPortlet {

	@Reference
	ArticleLocalService articleLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		List<Article> articles = articleLocalService.getAllArticles();
		renderRequest.setAttribute("articles", articles);

		super.doView(renderRequest, renderResponse);
	}

	public void navigateToAddPage(ActionRequest request, ActionResponse response) {
		response.getRenderParameters().setValue("mvcPath", "/add.jsp");
	}

	public void add(ActionRequest request, ActionResponse response) {
		String titre = ParamUtil.getString(request, "titre");
		String detail = ParamUtil.getString(request, "detail");

		try {
			articleLocalService.addArticle(titre, detail);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		} catch (Exception e) {
			// Gestion erreur
			response.getRenderParameters().setValue("mvcPath", "/add.jsp");
		}
	}

	public void display(ActionRequest request, ActionResponse response) throws PortalException {
		long articleId = ParamUtil.getLong(request, "articleId", 0L);

		if (articleId != 0L) {
			Article article = articleLocalService.getArticle(articleId);
			request.setAttribute("article", article);
			response.getRenderParameters().setValue("mvcPath", "/display.jsp");
		}
	}

	public void delete(ActionRequest request, ActionResponse response) throws PortalException {
		long articleId = ParamUtil.getLong(request, "articleId", 0L);

		if (articleId != 0L) {
			articleLocalService.deleteArticle(articleId);
			response.getRenderParameters().setValue("mvcPath", "/view.jsp");
		}
	}

	public void navigateToEditPage(ActionRequest request, ActionResponse response) throws PortalException {
		long articleId = ParamUtil.getLong(request, "articleId", 0L);

		if (articleId != 0L) {
			Article article = articleLocalService.getArticle(articleId);
			request.setAttribute("article", article);
			response.getRenderParameters().setValue("mvcPath", "/update.jsp");
		}
	}

	public void update(ActionRequest request, ActionResponse response) throws PortalException {
		long articleId = ParamUtil.getLong(request, "articleId", 0L);
		String titre = ParamUtil.getString(request, "titre");
		String detail = ParamUtil.getString(request, "detail");

		if (articleId > 0) {
			try {
				articleLocalService.updateArticle(articleId, titre, detail);
				response.getRenderParameters().setValue("mvcPath", "/view.jsp");
			} catch (Exception e) {
				request.setAttribute("article", articleLocalService.getArticle(articleId));
				response.getRenderParameters().setValue("mvcPath", "/update.jsp");
			}
		}
		response.setRenderParameter("mvcPath", "/view.jsp");
	}


}