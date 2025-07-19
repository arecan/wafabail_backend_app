<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<portlet:actionURL name="add" var="addURL" />

<aui:button class="btn btn-primary mb-3" type="cancel" value="Retour" onClick="history.back();" />

<aui:form action="<%= addURL %>" name="<portlet:namespace />fmStage" method="post" id="stageForm">
    <aui:fieldset>
        <aui:input required="true" id="titre" name="titre" label="Titre" />
        <aui:input required="true" id="detail" name="detail" label="Détails" type="textarea" rows="100" />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Ajouter" />
        <aui:button type="cancel" value="Annuler" onClick="history.back();" />
    </aui:button-row>
</aui:form>
