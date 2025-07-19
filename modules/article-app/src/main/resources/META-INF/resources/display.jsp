<%@ include file="/init.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

 <aui:button class="btn btn-primary mb-3" type="cancel" value="Retour" onClick="history.back();" />
<aui:fieldset>
    <aui:input
        required="true"
        id="titre"
        name="titre"
        label="Titre"
        disabled="true"
        value="${article.titre}"
    />

   <aui:input
       id="detail"
       name="detail"
       label="Détails"
       type="textarea"
       disabled="true"
       value="${article.detail}"
       rows="100"
   />
</aui:fieldset>
