<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


        <c:import url="/WEB-INF/includes/header.jsp" />

        <div class="gallery-container">
        
        <div class="gallery-container-top">
        	<div>
        		<h1>Liste des albums</h1>
        	</div>
        </div>
        	<div class="album-container">

            <c:if test="${ empty albums }">
                <h2 class="titre">Il y a pas d'albums disponible pour le moment.</h2>
                <a href="<c:url value="/user/album/add" />" class="blue-btn" style="width : 250px ;padding-bottom :40px; font-size : 30px;">Créer un nouvel album</a>
            </c:if>


            <c:if test="${ !empty albums }">
				<div class="float-button-right-bottom">
		        	<a href='<c:url value="/user/album/add"/>'>
		        		<i class="fa fa-plus"></i>
		        	</a>
		        </div>
        
                <c:forEach items="${ albums }" var="album">
                    <div class="album" onclick="showModal(this)">
                        <div class="album-overlay" style="display : none">
                            <div class="album-overlay-body">
                                <div class="title" onClick="(event)">
                                    <c:out value="${album.titre }" />
                                </div>
                                <div class="like">
                                    <a href='<c:url value="/user/album/update?album=${ album.id }"/>'>Editer</a>
                                </div>
                                <div class="delete">
                                    <a onclick="return confirm('Voulez-vous vraiment supprimer cet album ?');" href='<c:url value="/user/album/delete?album=${ album.id }"/>'>Supprimer</a>
                                </div>
                            </div>
                        </div>
                        <div class="album-content" style="background-image: url('<c:url value='/uploads/${album.images[0].fichierImage}'/>');">
                        </div>
                        <div class="album-menu" onClick="cancelModal(event);">
                        	<div>
                        		<i class="fa fa-heart"></i>
                        	</div>
                        </div>
                        <span hidden="true" class="album-id"><c:out value="${album.id}"/></span>
                        <span hidden="true" class="album-title"><c:out value="${album.titre}"/></span>
                        <span hidden="true" class="album-description"><c:out value="${album.description}"/></span>
                        <span hidden="true" class="album-proprio"><c:out value="${album.proprio.prenom} ${album.proprio.nom}"/></span>
                        <span hidden="true" class="album-date"><c:out value="${album.proprio.createdAt}"/></span>
                        <span hidden="true" class="album-taille"><c:out value="${album.images.size()}"/></span>
                        <span hidden="true" class="album-link"><a href='<c:url value="/user/album/view?album=${album.id}"/>'>Voir</a></span>
                    </div>
                </c:forEach>

				<!-- 
				<a class="add-albums-button rotating" href="<c:url value="/user/album/add"/>">
					<i class="fas fa-plus-circle"></i>
				</a>
				 -->
				
            </c:if>
        </div>
        </div>





        <c:import url="/WEB-INF/includes/footer.jsp" />