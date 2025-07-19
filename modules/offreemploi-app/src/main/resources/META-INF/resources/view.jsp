<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<liferay-ui:success key="offreemploiAdded" message="Offre d’emploi ajoutée avec succès." />
<liferay-ui:success key="offreemploiUpdated" message="Offre mise à jour avec succès." />
<liferay-ui:error key="error" message="Une erreur s'est produite." />

<a href="<portlet:actionURL name='navigateToAddPage'/>" class="btn btn-primary mb-3">
    Ajouter une Offre d'emploi
</a>

<liferay-ui:search-container delta="20" emptyResultsMessage="Aucune offre trouvée" total="${offreemplois.size()}">
    <liferay-ui:search-container-results results="${offreemplois}" />

    <liferay-ui:search-container-row
        className="offreemploi.model.Offreemploi"
        keyProperty="offreemploiId"
        modelVar="e"
        escapedModel="<%= true %>"
        cssClass="table">

        <liferay-ui:search-container-column-text name="Titre">
            <div class="truncate">${e.titre}</div>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Détails">
            <div class="truncate-3-lines">${e.detail}</div>
        </liferay-ui:search-container-column-text>
           <liferay-ui:search-container-column-text name="Date de Création">
                    <div class="truncate-3-lines" pattern='yyyy-MM-dd'>${e.dateCreation}</div>
                 </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Actions">
            <a href="<portlet:actionURL name='display'>
                        <portlet:param name='offreemploiId' value='${e.offreemploiId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="view" label="Voir" />
            </a>

            <a href="<portlet:actionURL name='navigateToEditPage'>
                        <portlet:param name='offreemploiId' value='${e.offreemploiId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="edit" label="Modifier" />
            </a>

            <a href="<portlet:actionURL name='delete'>
                        <portlet:param name='offreemploiId' value='${e.offreemploiId}' />
                    </portlet:actionURL>"
               onclick="return confirm('Confirmer la suppression de l\'offre ?');">
                <liferay-ui:icon image="delete" label="Supprimer" />
            </a>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" />
</liferay-ui:search-container>
