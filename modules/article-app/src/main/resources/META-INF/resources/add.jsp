<%@ include file="/init.jsp" %>
<script src="https://cdn.ckeditor.com/4.25.1-lts/full-all/ckeditor.js"></script>
<portlet:actionURL name="addArticle" var="addArticleURL" />

<h2>Ajouter un nouvel article</h2>

<aui:form action="${addArticleURL}" method="post">
    <aui:fieldset>
        <aui:input name="titre" label="Titre" required="true" />

        <aui:input name="detail" label="Detail" type="textarea" />

    </aui:fieldset>
    <aui:button-row>
        <aui:button type="submit" value="Ajouter" />
        <aui:button type="cancel" value="Annuler" onClick="history.back()" />
    </aui:button-row>
</aui:form>

<aui:script>
    CKEDITOR.replace('detail');
</aui:script>

