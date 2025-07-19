<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<portlet:actionURL name="update" var="updateURL" />
<aui:button class="btn btn-primary mb-3" type="cancel" value="Retour" onClick="history.back();" />

<aui:form action="<%= updateURL %>" name="<portlet:namespace />fmOffreemploi" method="post" id="emploiForm">
    <aui:fieldset>
        <aui:input type="hidden" name="offreemploiId" value="${offreemploi.offreemploiId}" />

        <aui:input required="true" id="titre" name="titre" label="Titre" value="${offreemploi.titre}" />

        <aui:input
            id="detail"
            name="detail"
            label="Détails"
            type="textarea"
            value="${offreemploi.detail}"
            rows="100"
        />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Modifier" onClick="setTimeout(function() { location.reload(); }, 1000);" />
        <aui:button type="cancel" value="Annuler" onClick="history.back();" />
    </aui:button-row>
</aui:form>
