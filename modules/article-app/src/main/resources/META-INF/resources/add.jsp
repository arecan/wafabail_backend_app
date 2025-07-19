<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<portlet:actionURL name="ajouter" var="addURL" />

<aui:button class="btn btn-primary mb-3" type="cancel" value="Retour" onClick="history.back();" />

<aui:form action="<%= addURL %>" name="<portlet:namespace />fmArticle" method="post" id="articleForm">
    <aui:fieldset>
        <!-- Champ Titre -->
        <aui:input required="true" id="titre" name="titre" label="Titre" />

        <!-- Champ Détail -->
        <aui:input required="true"
            id="detail"
            name="detail"
            label="Détails"
            type="textarea"
            rows="100"
        />

        <!-- Champ Date de création -->
        <aui:input
            required="true"
            id="dateCreation"
            name="dateCreation"
            label="Date de création"
            type="date"
        />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Ajouter" />
        <aui:button type="cancel" value="Annuler" onClick="history.back();" />
    </aui:button-row>
</aui:form>
