<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <c:import url="/WEB-INF/includes/header.jsp" />
        <div class="gallery-container">
        <div class="gallery-container-top">
        	<div>
        		<h1>Liste des albums</h1>
        	</div>
        </div>
        	<div class="album-container">
            <c:if test="${ empty albums }">
                <h2 class="titre" style="text-align : center; font-size : 30px; margin-top : 40px; font-weight : bold;"><i class="far fa-lightbulb flicker-2" style="color : #ffb100;"></i><br>Il y a pas d'albums disponible pour le moment.</h2>
                <div class="float-button-right-bottom">
	  				Cr&eacute;er un album
				<a class="add-albums-button" href="<c:url value="/user/album/add"/>">
					<i class="fas fa-plus-circle"></i>
				</a>
				 </div>
            </c:if>
            <c:if test="${ !empty albums }">
                <div class="album-container">
                <c:forEach items="${ albums }" var="album">
                    <div class="album" onclick="showModal(this)">
                        <div class="album-content" onClick="showImageModal(event);" style="background-image:url('/uploads/${ album.images[0].fichierImage }')">
                        </div>
                        
                        <div class="album-info">
                            <div class="album-title"><c:out value="${album.titre}" /></div>
                            <span hidden="true" class="album-id"><c:out value="${album.id}"/></span>
                        <span hidden="true" class="album-title"><c:out value="${image.titre}"/></span>
                        <span hidden="true" class="album-description"><c:out value="${album.description}"/></span>
                        <span hidden="true" class="album-proprio"><c:out value="${album.proprio.prenom} ${album.proprio.nom}"/></span>
                        <span hidden="true" class="album-date"><c:out value="${fn:substring(album.createdAt,0,10)}"/></span>
                        <span hidden="true" class="album-taille"><c:out value="${album.images.size()}"/></span>
                        <c:if test="${ sessionScope.utilisateur == null }">
			                <span hidden="true" class="album-link"><a href='<c:url value="/gallery/photos?album=${album.id}"/>'>Voir</a></span>
				        </c:if>
				        <c:if test="${ sessionScope.utilisateur != null }">
                        	<span hidden="true" class="album-link"><a href='<c:url value="/user/album/images?album=${album.id}"/>'>Voir</a></span>
                        </c:if>
                        </div>
                        
                        <c:if test="${ sessionScope.utilisateur != null }">
				        		<c:if test="${ sessionScope.utilisateur.email == album.proprio.email }">
					        		<div>
					        			<a href='<c:url value="/user/album/update?album=${ album.id }"/>'><i class="fa fa-edit"></i></a>
					        			<a onclick="return confirm('Voulez-vous vraiment supprimer cet album ?');" href='<c:url value="/user/album/delete?album=${ album.id }"/>'><i class="fa fa-trash"></i></a>
					        		</div>
				        		</c:if>
				        </c:if>
                    </div>
                </c:forEach>
            </div>
            
				<div class="float-button-right-bottom">
	  				Creer un album
				<a class="add-albums-button" href="<c:url value="/user/album/add"/>">
					<i class="fas fa-plus-circle"></i>
				</a>
				 </div>
            </c:if>
            
        </div>
        </div>
<script>
	<c:if test="${  param.success == 'true' }">
	window.addEventListener("DOMContentLoaded",(event) => {
	    showMessage("<c:out value=" Album ajoute avec success "/>");
	});
	</c:if>
</script>
<c:import url="/WEB-INF/includes/footer.jsp" />