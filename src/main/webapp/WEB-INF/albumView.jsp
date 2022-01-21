<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:import url="/WEB-INF/includes/header.jsp" />
<link rel="stylesheet" href='<c:url value="/css/albumView.css"/>'>

<c:if test="${ empty album.images }">
<div class="message success" style="text-align : center; font-size : 40px; margin-top : 40px; font-weight : bold; display : grid; justify-items : center;">
              		<div class="vibrate-3 tumble" style="background-image : url('<c:url value="/assests/tumble.jpg"/>') , url('https://picsum.photos/500/300')">
              		
              		</div>
              
                    <br/>
                    Cet Album ne contient pas d'images :(
</div>
</c:if>

<div class="float-button-right-bottom">
		        	<a href='<c:url value="/user/album/add"/>'>
		        		<i class="fa fa-plus"></i>
		        	</a>
</div>
		        
<c:if test="${ !empty album.images }">
    <div class="container">
    
        <div class="gallery-container">
            <div class="tags-container">
                <div class="tag">
                    <a href="#">Summer</a>
                </div>
                <div class="tag">
                    <a href="#">Summer</a>
                </div>
            </div>
            <div class="images-container">
                <c:forEach items="${ album.images }" var="image">
                    <div class="image">
                        <!-- 
                        Uncomment this if local images work for you!!!!!
                        <div class="image-body" onClick="showImageModal(event);" style="background-image:url('<c:url value='/uploads/${ image.fichierImage }'/>')">
    
                        </div>
                        -->
                        <div class="image-body" onClick="showImageModal(event);" style="background-image : url('https://picsum.photos/500/600')">
    
                        </div>
                        <div class="image-info">
                            <div class="image-title"><c:out value="${image.titre.split(' ')[3]}" /></div>
                            <div class="image-details">some cool bullshit</div>
                            <span hidden="true" class="album-id"><c:out value="${album.id}"/></span>
                        <span hidden="true" class="album-title"><c:out value="${album.titre}"/></span>
                        <span hidden="true" class="album-description"><c:out value="${album.description}"/></span>
                        <span hidden="true" class="album-proprio"><c:out value="${album.proprio.prenom} ${album.proprio.nom}"/></span>
                        <span hidden="true" class="album-date"><c:out value="${album.proprio.createdAt}"/></span>
                        <span hidden="true" class="album-taille"><c:out value="${album.images.size()}"/></span>
                        <span hidden="true" class="album-link"><a href='<c:url value="user/album/view?album=${album.id}"/>'>Voir</a></span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

</c:if>


<script src='<c:url value="/js/albumView.js"/>'></script>
<c:import url="/WEB-INF/includes/footer.jsp" />