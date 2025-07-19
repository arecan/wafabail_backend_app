<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />

<liferay-ui:success key="revueAdded" message="Revue ajoutée avec succès." />
<liferay-ui:success key="revueUpdated" message="Revue mise à jour avec succès." />
<liferay-ui:error key="error" message="Une erreur s'est produite." />

<a href="<portlet:actionURL name='navigateToAddPage'/>" class="btn btn-primary mb-3">
    Ajouter une Revue
</a>

<liferay-ui:search-container delta="20" emptyResultsMessage="Aucune revue trouvée" total="${revues.size()}">
    <liferay-ui:search-container-results results="${revues}" />

    <liferay-ui:search-container-row
        className="revue.model.Revue"
        keyProperty="revueId"
        modelVar="r"
        escapedModel="<%= true %>"
        cssClass="table">

        <liferay-ui:search-container-column-text name="Titre">
            <div class="truncate">${r.titre}</div>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Détails">
            <div class="truncate-3-lines">${r.details}</div>
        </liferay-ui:search-container-column-text><
        liferay-ui:search-container-column-text name="Lien">
            <div class="truncate-3-lines">${r.lien}</div>
        </liferay-ui:search-container-column-text>
         <liferay-ui:search-container-column-text name="Date de Création">
            <div class="truncate-3-lines" pattern='yyyy-MM-dd'>${r.dateCreation}</div>
         </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Actions">
            <a href="<portlet:actionURL name='display'>
                        <portlet:param name='revueId' value='${r.revueId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="view" label="Voir" />
            </a>

            <a href="<portlet:actionURL name='navigateToEditPage'>
                        <portlet:param name='revueId' value='${r.revueId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="edit" label="Modifier" />
            </a>

            <a href="<portlet:actionURL name='delete'>
                        <portlet:param name='revueId' value='${r.revueId}' />
                    </portlet:actionURL>"
               onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette revue ?');">
                <liferay-ui:icon image="delete" label="Supprimer" />
            </a>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" />
</liferay-ui:search-container>
