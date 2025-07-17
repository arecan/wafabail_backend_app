<%@ include file="/init.jsp" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="article.model.Article" %>
<%@ page import="java.util.List" %>

<%
	List<Article> articles = (List<Article>) request.getAttribute("articles");
%>

<portlet:renderURL var="addArticleURL">
    <portlet:param name="mvcPath" value="/add.jsp" />
</portlet:renderURL>

<div class="add-article-button" style="margin-bottom: 20px;">
    <aui:button value="Ajouter un article" onClick="location.href='${addArticleURL}'" />
</div>

<c:if test="${not empty articles}">
	<table class="article-table">
		<thead>
			<tr>
				<th>Titre</th>
				<th>Détail</th>
				<th>Date de création</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td>${article.titre}</td>
					<td>${article.detail}</td>
					<td><fmt:formatDate value="${article.dateCreation}" pattern="dd/MM/yyyy" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</c:if>

<c:if test="${empty articles}">
	<p>Aucun article trouvé.</p>
</c:if>
