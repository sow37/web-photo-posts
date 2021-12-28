<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="./Includes/header.jsp"/>

<div class="modal">
    <div class="modal-body">
        <div class="modal-close">
            X
        </div>
    </div>
</div>
<div class="overlay" hidden="true">

</div>

<div class="container">


    <c:if test="${ empty albums }">
	          		<h2 class="titre">Il y a pas d'albums disponible pour le moment.</h2>
	          		<a href="<c:url value="/user/album/add" />" class="btn btn-success">Créer un nouvel album</a>
	</c:if>

    <c:if test="${ !empty albums }">

        <div class="tags">


            <div class="tag">
                <a href="#">All Albums</a>
            </div>
            <div class="tag">
                <a href="#">Weddings</a>
            </div>
            <div class="tag">
                <a href="#">School</a>
            </div>
        </div>

        <div class="images">
            <c:forEach items="${ albums }" var="album">
                
                <div class="image">
                    <div class="photo">
                        <img src="<c:url value='/uploads/${album.images[0].fichierImage}'/>" alt="">
                    </div>
                    <div>
                        <a href="#">Tag Shit</a>
                    </div>
                    <div class="image-title">
                        <a href="#">
                            <c:out value="${album.titre }" />
                        </a>
                    </div>
                    <div>
                        <a href="#">
                            <c:out value="${album.description }" />
                        </a>
                    </div>
                </div>

            </c:forEach>


            <div class="load-more">
                <button>
                    load-more
                </button>
            </div>

        </div>



        

        
        
    </c:if>


    


    
</div>



<c:import url="./Includes/footer.jsp"/>