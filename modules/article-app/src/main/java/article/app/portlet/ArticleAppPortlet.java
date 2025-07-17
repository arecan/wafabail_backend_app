package article.app.portlet;

import article.app.constants.ArticleAppPortletKeys;

import article.model.Article;
import article.service.ArticleLocalService;
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

	private static final Log _log = LogFactoryUtil.getLog(ArticleAppPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			List<Article> articles = articleLocalService.getAllArticles();

			renderRequest.setAttribute("articles", articles);

		} catch (Exception e) {
			_log.error("Erreur lors du chargement des articles dans la vue", e);
		}
		super.doView(renderRequest, renderResponse);
	}

	@ProcessAction(name = "addArticle")
	public void addArticle(ActionRequest actionRequest, ActionResponse actionResponse) {

		String titre = ParamUtil.getString(actionRequest, "titre");
		String detail = ParamUtil.getString(actionRequest, "detail");

		try {
			articleLocalService.addArticle(titre, detail);
			SessionMessages.add(actionRequest, "articleAddedSuccessfully");

			_log.info("Article ajouté avec succès.");

		} catch (Exception e) {
			_log.error("Erreur lors de l'ajout de l'article", e);
			SessionErrors.add(actionRequest, "errorAddingArticle");
		}
	}

	@ProcessAction(name = "updateArticle")
	public void updateArticle(ActionRequest actionRequest, ActionResponse actionResponse) {

		long articleId = ParamUtil.getLong(actionRequest, "articleId");
		String titre = ParamUtil.getString(actionRequest, "titre");
		String detail = ParamUtil.getString(actionRequest, "detail");

		try {
			articleLocalService.updateArticle(articleId, titre, detail);
			SessionMessages.add(actionRequest, "articleUpdatedSuccessfully");

		} catch (Exception e) {
			_log.error("Erreur lors de la mise à jour de l'article", e);
			SessionErrors.add(actionRequest, "errorUpdatingArticle");
		}
	}





}