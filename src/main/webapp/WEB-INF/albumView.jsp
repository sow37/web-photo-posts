<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<c:import url="/WEB-INF/includes/header.jsp" />
<link rel="stylesheet" href='<c:url value="/css/albumView.css"/>'>

<c:if test="${ empty album.images }">
<div class="message success" style="text-align : center; font-size : 40px; margin-top : 40px; font-weight : bold; display : grid; justify-items : center;">
              		<div class="vibrate-3 tumble" style="background-image : url('<c:url value="/assests/tumble.jpg"/>') , url('https://picsum.photos/500/300')">
              		              		</div>
              
                    <br/>
                    Cet Album ne contient pas d'images
                    <br/>
</div>
</c:if>

<div class="float-button-right-bottom">
		        	<a href='<c:url value="/user/album/add"/>' style="color: white;">
		        		<i class="fa fa-plus">Ajouter un album</i>
		        	</a>
</div>	        
<c:if test="${ !empty album.images }">
    <div class="container">
        <div class="gallery-container">
            <div>
                <c:if test="${ !empty album.images }">
	          		<h2 class="titre">Images de l'album <c:out value="${ album.titre }"/></h2>
	          		<div class="container">
	          		<p class="titre"><c:out value="${ album.description }"/></p>
	          		</div>
				</c:if>
            </div><br><br><br><br>
            <div class="images-container">
                <c:forEach items="${ album.images }" var="image">
                    <div class="image">
                        <div class="image-body" onClick="showImageModal(event);" style="background-image:url('/uploads/${ image.fichierImage }')">
                        </div>
                        <div class="image-info">
                            <div class="image-title"><c:out value="${image.titre}" /></div>
                            <span hidden="true" class="album-id"><c:out value="${album.id}"/></span>
                        <span hidden="true" class="album-title"><c:out value="${image.titre.split(' ')[3]}"/></span>
                        <span hidden="true" class="album-description"><c:out value="${image.description}"/></span>
                        <span hidden="true" class="album-proprio"><c:out value="${album.proprio.prenom} ${album.proprio.nom}"/></span>
                        <span hidden="true" class="album-date"><c:out value="${fn:substring(image.createdAt,0,10)}"/></span>
                        <span hidden="true" class="album-taille"><c:out value="${album.images.size()}"/></span>
                        <span hidden="true" class="album-link"><a href='<c:url value="/user/album/view?album=${album.id}"/>'></a></span>
                        </div>
                        <c:if test="${ sessionScope.utilisateur != null }">
				        		<c:if test="${ sessionScope.utilisateur.email == album.proprio.email }">
					        		<div>
					        			<a href="<c:url value="/user/album/image/update?image=${ image.id }" />" class="btn btn-warning" title="Editer cette image"><i class="fa fa-edit"></i></a>
					        			<a href="<c:url value="/user/album/image/delete?image=${ image.id }" />" onclick="return confirm('Voulez vous vraiment supprimer cette image ?');" class="btn btn-danger" title="Supprimer cette image"><i class="fa fa-trash"></i></a>
					        		</div>
				        		</c:if>
				        </c:if>
                    </div>
                </c:forEach>
            </div>
            <div class="container">
                <c:if test="${ sessionScope.utilisateur != null }">
				        		<c:if test="${ sessionScope.utilisateur.email == album.proprio.email }">
					        		<div>
					        			<a href="<c:url value="/user/album/image/add?album=${ album.id }" />" class="btn btn-success"><i class="fa fa-plus"></i>Ajouter nouvelle image a album</a>
					        		</div>
				        		</c:if>
				        </c:if>
				</div>
				<br>
        </div>
    </div>

</c:if>
<script src='<c:url value="/js/albumView.js"/>'></script>
<script>
	<c:if test="${ !empty success }">
	window.addEventListener("DOMContentLoaded",(event) => {
	    showMessage("<c:out value=" ${ success }"/>");
	});
	</c:if>
</script>
<c:import url="/WEB-INF/includes/footer.jsp" />