<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-ui:success key="offrestageAdded" message="Stage ajouté avec succès." />
<liferay-ui:success key="offrestageUpdated" message="Stage mis à jour avec succès." />
<liferay-ui:error key="error" message="Une erreur s'est produite." />

<a href="<portlet:actionURL name='navigateToAddPage'/>" class="btn btn-primary mb-3">
    Ajouter un Stage
</a>

<liferay-ui:search-container delta="20" emptyResultsMessage="Aucun stage trouvé" total="${offrestages.size()}">
    <liferay-ui:search-container-results results="${offrestages}" />

    <liferay-ui:search-container-row
        className="offrestage.model.Offrestage"
        keyProperty="stageId"
        modelVar="s"
        escapedModel="<%= true %>"
        cssClass="table">

        <liferay-ui:search-container-column-text name="Titre">
            <div class="truncate">${s.titre}</div>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Détails">
            <div class="truncate-3-lines">${s.detail}</div>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Actions">
            <a href="<portlet:actionURL name='display'>
                        <portlet:param name='stageId' value='${s.stageId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="view" label="Voir" />
            </a>

            <a href="<portlet:actionURL name='navigateToEditPage'>
                        <portlet:param name='stageId' value='${s.stageId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="edit" label="Modifier" />
            </a>

            <a href="<portlet:actionURL name='delete'>
                        <portlet:param name='stageId' value='${s.stageId}' />
                    </portlet:actionURL>"
               onclick="return confirm('Supprimer ce stage ?');">
                <liferay-ui:icon image="delete" label="Supprimer" />
            </a>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" />
</liferay-ui:search-container>
