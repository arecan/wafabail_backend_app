<%@ include file="/init.jsp" %>
<link rel="stylesheet" type="text/css" href="https://cdn.ckeditor.com/4.14.1/full-all/skins/moono/editor.css">
<script src="https://cdn.ckeditor.com/4.14.1/full-all/ckeditor.js"></script>
<portlet:actionURL name="addArticle" var="addArticleURL" />

<h2>Ajouter un nouvel article</h2>

<aui:form action="${addArticleURL}" method="post">
    <aui:fieldset>
        <aui:input name="titre" label="Titre" required="true" />
        <label>Detail: <br></label>
        <textarea id="detail" name="<portlet:namespace />detail"></textarea>
    </aui:fieldset>
    <aui:button-row>
        <aui:button type="submit" value="Ajouter" />
        <aui:button type="cancel" value="Annuler" onClick="history.back()" />
    </aui:button-row>
</aui:form>
<aui:script>
    CKEDITOR.replace('detail');
</aui:script>
