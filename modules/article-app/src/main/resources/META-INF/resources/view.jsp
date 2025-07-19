<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<liferay-ui:success key="articleAdded" message="Article ajouté avec succès." />
<liferay-ui:success key="articleUpdated" message="Article mis à jour avec succès." />
<liferay-ui:error key="error" message="Une erreur s'est produite." />


<a href="<portlet:actionURL name='navigateToAddPage'/>" class="btn btn-primary mb-3">
    Ajouter un Article
</a>

<liferay-ui:search-container delta="20" emptyResultsMessage="Aucun article trouvé" total="${articles.size()}">
    <liferay-ui:search-container-results results="${articles}" />

    <liferay-ui:search-container-row
        className="article.model.Article"
        keyProperty="articleId"
        modelVar="a"
        escapedModel="<%= true %>"
        cssClass="table">

        <liferay-ui:search-container-column-text name="Titre">
            <div class="truncate">${a.titre}</div>
        </liferay-ui:search-container-column-text>

       <liferay-ui:search-container-column-text name="Détails">
           <div class="truncate-3-lines">${a.detail}</div>
       </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text name="Date de Création">
                  <div class="truncate-3-lines" pattern='yyyy-MM-dd'>${a.dateCreation}</div>
         </liferay-ui:search-container-column-text>


        <liferay-ui:search-container-column-text name="Actions">
            <a href="<portlet:actionURL name='display'>
                        <portlet:param name='articleId' value='${a.articleId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="view" label="Voir" />
            </a>

            <a href="<portlet:actionURL name='navigateToEditPage'>
                        <portlet:param name='articleId' value='${a.articleId}' />
                    </portlet:actionURL>">
                <liferay-ui:icon image="edit" label="Modifier" />
            </a>

     <a href="<portlet:actionURL name='delete'>
                 <portlet:param name='articleId' value='${a.articleId}' />
             </portlet:actionURL>"
        onclick="if(confirm('Êtes-vous sûr de vouloir supprimer cet article ?')) {
            setTimeout(function(){ location.reload(); }, 1000);
            return true;
        } else {
            return false;
        }">
         <liferay-ui:icon image="delete" label="Supprimer" />
     </a>
        </liferay-ui:search-container-column-text>

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon" paginate="<%= true %>" />
</liferay-ui:search-container>
