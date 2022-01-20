<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/includes/header.jsp"/>
<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 align="center">Veuillez saisir les informations de l'image</h1>
			</div>
		</div>
			<div style="display: none;" id="er" class="col-md-offset-2 alert alert-danger alert-dismissable col-md-8">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<h4 id="messageError"></h4>
			</div>
		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<div class="panel panel-default">
					<div class="panel panel-heading">
						<c:out value="${ requestScope.update == 'update' ? 'Edition' : 'Ajout' }"/> d'une image de l'album <strong><c:out value="${ requestScope.albumTitle }"/></strong>
					</div>
					<div class="panel panel-body">
						<form enctype="multipart/form-data" id="form" action="<c:url value="${ requestScope.update == 'add' ? '/user/album/image/add' : '/user/album/image/update' }" />" method="post">
			                <p class="error" id="videError" style="display: none;">
			                    	Veuillez remplir tous les champs.
			                 </p>
			                <div class="form-group">
			                    <label for="titre">Titre</label>
			                    <p class="error" id="titreError" style="display: none;">
			                    	Le titre doit comporter au minimum deux (2) caractères.
			                    </p>
			                    <input type="text" class="form-control" id="titre" name="titre" value="<c:out value="${ form.titre }"/>" placeholder="Titre de l'image...">
			                </div>
			                <div class="form-group">
			                    <label for="description">Description</label>
			                    <p class="error" id="descriptionError" style="display: none;">
			                    	La description doit comporter au minimum deux (2) caractères.
			                 	</p>
			                    <textarea class="form-control" id="description" placeholder="Description de l'image..." name="description"><c:out value="${ form.description }"/></textarea>
			                	<div class="invalid-feedback" id="description" style="display: none;">Veuillez saisir tous les champs</div>
			                </div>
			                <div class="form-group">
			                    <label for="hauteur">Hauteur</label>
			                    <p class="error" id="hauteurError" style="display: none;">
			                    	La hauteur saisie n'est pas valide.
			                    </p>
			                    <input type="text" class="form-control" id="hauteur" name="hauteur" value="<c:out value="${ form.hauteur }"/>" placeholder="Hauteur de l'image...">
			                </div>
			                <div class="form-group">
			                    <label for="largeur">Largeur</label>
			                    <p class="error" id="largeurError" style="display: none;">
			                    	La largeur saisie n'est pas valide.
			                    </p>
			                    <input type="text" class="form-control" id="largeur" name="largeur" value="<c:out value="${ form.largeur }"/>" placeholder="Largeur de l'album...">
			                </div>
			                <div class="form-group">
			                    <label for="images">Image</label>
			                    <div id="myDropzone" class="dropzone">
			                    <input type="file" name="image" />
								</div>
			                </div>
			                <div class="form-group">
			                    <a href="<c:url value="/user/albums"/>" class="btn btn-danger btn-md">Annluer</a>
			                    <button type="submit" id="btnSubmit" class="btn btn-success btn-md"><c:out value="${ requestScope.update == 'update' ? 'Editer' : 'Ajouter' }"/></button>
			                </div>
			                    <input type="hidden" id="albumId" name="albumId" value="${ requestScope.albumId }" />
			                    <c:if test="${ requestScope.update == 'update' }">
			                    	<input type="hidden" id="imageId" name="imageId" value="${ image.id }" />
			                    </c:if>
            			</form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
<c:import url="/WEB-INF/includes/footer.jsp"/>