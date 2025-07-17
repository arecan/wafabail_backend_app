<portlet:actionURL name="updateArticle" var="updateArticleURL">
    <portlet:param name="articleId" value="${article.articleId}" />
</portlet:actionURL>

<aui:form action="${updateArticleURL}" method="post">
    <aui:fieldset>
        <aui:input name="titre" label="Titre" value="${article.titre}" required="true" />
        <aui:input name="detail" type="textarea" label="Détail" value="${article.detail}" required="true" />
    </aui:fieldset>
    <aui:button type="submit" value="Mettre à jour" />
</aui:form>
