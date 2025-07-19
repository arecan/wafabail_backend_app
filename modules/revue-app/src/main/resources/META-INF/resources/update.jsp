<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<portlet:actionURL name="modifier" var="updateURL" />
<aui:button class="btn btn-primary mb-3" type="cancel" value="Retour" onClick="history.back();" />

<aui:form action="<%= updateURL %>" name="<portlet:namespace />fmRevue" method="post" id="revueForm">
    <aui:fieldset>
        <aui:input type="hidden" name="revueId" value="${revue.revueId}" />

        <aui:input required="true" id="titre" name="titre" label="Titre" value="${revue.titre}" />

        <aui:input
            id="details"
            name="details"
            label="Détails"
            type="textarea"
            value="${revue.details}"
            rows="100"
        />

        <aui:input id="lien" name="lien" label="Lien" value="${revue.lien}" />

             <aui:input
                 id="dateCreation"
                 name="dateCreation"
                 label="Date de création"
                 type="date"
                 value="${revue.dateCreation}"
             />
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="Modifier" onClick="setTimeout(function() { location.reload(); }, 1000);" />
        <aui:button type="cancel" value="Annuler" onClick="history.back();" />
    </aui:button-row>
</aui:form>
