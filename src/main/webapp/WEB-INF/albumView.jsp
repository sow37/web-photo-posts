<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/includes/header.jsp"/>
<div class="container">
	        <div class="heading">
				<c:if test="${ empty album.images }">
	          		<h2 class="titre">Il y a pas d'images dans cet album.</h2>
	          		<a href="<c:url value="/user/album/add" />" class="btn btn-success">Créer un nouvel album</a>
				</c:if>
				<c:if test="${ !empty album.images }">
	          		<h2 class="titre">Images de l'album <a href="#" data-toggle="modal" data-target="#modalAlbum"><c:out value="${ album.titre }"/></a></h2>
	          		<a href="<c:url value="/user/album/add" />" class="btn btn-success">Créer un nouvel album</a><br>
	          		
				</c:if>
	        </div>
	        <c:if test="${ !empty album.images }">
	        	<div class="row">
	        		<c:forEach items="${ album.images }" var="image">
	                    <div class="col-md-6 col-lg-4 item">
	                        <a class="lightbox" href="<c:url value="/uploads/${ image.fichierImage }" />">
	                            <img class="img-fluid image scale-on-hover" style="width: 100%; height: 250px;" alt="<c:out value="${ image.description }" />" class="card-img-top" src="<c:url value="/uploads/${ image.fichierImage }" />">
	                        </a>
	                        <br>
	                        <a href="<c:url value="/user/album/image/add?album=${album.id }" />" class="btn btn-success">Ajouter nouvelle image a album</a>
			                <div>
			                    <h6 class="card-title">
			                       <a href="#" data-toggle="modal" data-target="#modal-<c:out value="${ image.id }" />"><c:out value="${image.titre }" /></a>
			                    </h6>
				        	<c:if test="${ sessionScope.user != null }">
				        		<c:if test="${ sessionScope.utilisateur.email == album.proprio.email }">
					        		<div>
					        			<a href="<c:url value="/user/album/image/add" />" class="btn btn-success">Ajouter nouvelle image a album</a>
					        			<a href="<c:url value="/user/album/image/update?image=${ image.id }" />" class="btn btn-warning" title="Editer cette image"><i class="fa fa-edit"></i></a>
					        			<a href="<c:url value="/user/album/image/delete?image=${ image.id }" />" onclick="return confirm('Voulez vous vraiment supprimer cette image ?');" class="btn btn-danger" title="Supprimer cette image"><i class="fa fa-trash"></i></a>
					        		</div>
				        		</c:if>
				        	</c:if>
			                </div>
			        	<!-- Modal -->
						<div id="modal-<c:out value="${ image.id }" />" class="modal fade" role="dialog">
						  <div class="modal-dialog">
						
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title">Informations de l'image</h4>
						      </div>
						      <div class="modal-body">
						      	<table class="table table-striped">
						      		<tr>
						      			<th>Titre</th>
						      			<th>Description</th>
						      			<th>Largeur</th>
						      			<th>Hauteur</th>
						      			<th>Date de création</th>
						      		</tr>
						      		<tr>
						      			<td><c:out value="${ image.titre }" /></td>
						      			<td><c:out value="${ image.description }" /></td>
						      			<td><c:out value="${ image.largeur }" /></td>
						      			<td><c:out value="${ image.hauteur }" /></td>
						      			<td><c:out value="${ image.createdAt }"/></td>
						      		</tr>
						      	</table>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						      </div>
						    </div>
						
						  </div>
						</div>
	                    </div>
	        		</c:forEach>
	        	</div>
	        	
			        	<!-- Modal -->
						<div id="modalAlbum" class="modal fade" role="dialog">
						  <div class="modal-dialog">	
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title">Informations de l'album</h4>
						      </div>
						      <div class="modal-body">
						      	<table class="table table-striped">
						      		<tr>
						      			<th>Titre</th>
						      			<th>Description</th>
						      			<th>Statut</th>
						      			<th>Propriétaire</th>
						      			<th>Date de création</th>
						      			<th>Images</th>
						      		</tr>
						      		<tr>
						      			<td><c:out value="${ album.titre }" /></td>
						      			<td><c:out value="${ album.description }" /></td>
						      			<td><c:out value="${ album.statut == 'publique' ? 'Public' : 'Privé' }" /></td>
						      			<td><c:out value="${ album.proprio.prenom } ${ album.proprio.nom }" /></td>
						      			<td><c:out value="${ album.proprio.createdAt }"/></td>
						      			<td><c:out value="${ album.images.size() }"/></td>
						      		</tr>
						      	</table>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						      </div>
						    </div>
						
						  </div>
						</div>
	        </c:if>
	    </div>

<c:import url="/WEB-INF/includes/footer.jsp"/>