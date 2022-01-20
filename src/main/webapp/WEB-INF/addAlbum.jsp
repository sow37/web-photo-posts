<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:import url="/WEB-INF/includes/header.jsp" />
        <link rel="stylesheet" href='<c:url value="/css/addAlbum.css"/>'>


        <div class="container">
            <form class="addAlbum fade-in-top" enctype="multipart/form-data" id="form" action="<c:url value="${requestScope.update=='add' ? '/user/album/add' : '/user/album/update' }" />" method="post">
            <div class="header">
                <div style="padding-left: 20px;">
                    <c:out value="${ requestScope.update == 'update' ? 'Edition' : 'Création' }" /> d'un album
                </div>
                <hr>
            </div>
            <div class="body">
                <div>
                    <span class="input-title">Title</span>
                    <br>
                    <input type="text" class="form-control body-input" id="titre" name="titre" value="<c:out value=" ${ form.titre
                        }" />" placeholder="Titre de l'album...">
                </div>
                <div>
                    <span class="input-title">Description</span>
                    <br>
                    <textarea class="form-control body-input" id="description" placeholder="Description de l'album..."
                        name="description"><c:out value="${ form.description }"/></textarea>
                </div>
                <div>
                    <span>Statut</span>
                    <br>
                    <select id="statut" class="statut" name="statut" class="form-control">
                        <option value="public" <c:out value="${ form.statut == 'public' ? 'selected' : '' }" /> >Public
                        </option>
                        <option value="prive" <c:out value="${ form.statut == 'privé' ? 'selected' : '' }" /> >Privé
                        </option>
                    </select>
                </div>
                <div id="usersAuth" class="usersAuth" style="display: none;">
                    <span></span>
                    <br>
                    <select id="users" name="users" multiple class="form-control">
                        <c:if test="${ users != null }">
                            <c:forEach items="${ users }" var="user">
                                <option value="<c:out value=" ${ user.id }" />">
                                <c:out value="${ user.prenom } ${ user.nom } (${ user.compte.login })" />
                                </option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
                <div>
                    <span class="input-title">Attach Documents</span>
                    <br>
                    <div class="dropzone drop-area">
                        <div class="drop-zone-text">
                            <div>
                                Drag and Drop here <br>
                                or
                                <input type="file" name="" id="" class="upload" value="browse">
                            </div>

                        </div>
                    </div>
                    <span class="dropzone-bottom-text">
                        accepted file types png,jpg
                    </span>
                </div>
                <div>
                    <input type="submit" value='<c:out value="${ requestScope.update == ' update' ? 'Editer' : 'Ajouter'
                        }" />'>
                </div>
                <c:if test="${ requestScope.update == 'update' }">
                    <input type="hidden" name="userId" value="${ sessionScope.utilisateur.id }" />
                </c:if>
                <input type="hidden" name="album" value="${ param.album }" />
            </div>
            </form>
        </div>



        <script src='<c:url value="/js/addAlbum.js"/>'></script>
        <c:import url="/WEB-INF/includes/footer.jsp" />