<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<aui:button class="btn btn-primary mb-3" type="cancel" value="Retour" onClick="history.back();" />

<aui:fieldset>
    <aui:input
        id="titre"
        name="titre"
        label="Titre"
        disabled="true"
        value="${revue.titre}"
    />

    <aui:input
        id="details"
        name="details"
        label="Détails"
        type="textarea"
        disabled="true"
        value="${revue.details}"
        rows="100"
    />

    <aui:input
        id="lien"
        name="lien"
        label="Lien"
        disabled="true"
        value="${revue.lien}"
    />
</aui:fieldset>
