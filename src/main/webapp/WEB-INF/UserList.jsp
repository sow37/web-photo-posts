<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:import url="./includes/header.jsp" />


        <link rel="stylesheet" href='<c:url value="/css/userList.css"/>'>

        <c:choose>
            <c:when test="${ empty requestScope.users }">
<<<<<<< HEAD
                <div class="message success" style="text-align : center; font-size : 40px; margin-top : 40px; font-weight : bold;">
                    <i class="far fa-lightbulb flicker-2" style="color : #ffb100;"></i>
=======
                <div class="container">
                	<div class="message success" style="text-align : center; font-size : 40px; margin-top : 40px; font-weight : bold;">
                    <i class="far fa-lightbulb flicker-2" style="color : #ffb100; font-size : 150pt;"></i>
>>>>>>> 07cb917e36fc2b687c3ee938862706a73e59eafb
                    <br/>
                    Aucun utilisateur de ce type pour le moment
                </div>
                </div>
            </c:when>
            <c:otherwise>

                <div class="container fade-in">
					<div>
						<h1>Liste des utilisateurs</h1>
					</div>

                    <c:forEach items="${ users }" var="user">


                        <div class="user-dropdown">
                            <div><c:out value="${ user.nom }" /></div>
                            <div><c:out value="${ user.prenom }" /></div>
                            <div><c:out value="${ user.compte.login }" /></div>
                            <div><c:out value="${ user.email }" /></div>
                            <div><c:out value="${ user.profil == 'admin' ? 'Administrateur' : 'Utilisateur' }" /></div>
                            <div class="dropdown-icon">
                                <i class="fa fa-caret-down"></i>
                            </div>
                            <div class="user-body">
                                <div>
                                    <a class="red-btn" onclick="return confirm('Voulez-vous vraiment supprimer cet utilisateur ?');" href="<c:url value="/user/delete?user=${ user.id }" />">Supprimer </a>
                                </div>
                                <div>
                                    <a class="grey-btn" href="<c:url value="/user/edit?user=${ user.id }" />">Editer</a>
                                </div>
                                <div>
                                    <a class="grey-btn" href="<c:url value="/user/upgrade?user=${ user.id }" />">Rendre ${ user.profil == 'admin' ? 'Utilisateur'  : 'Administrateur' }</a>
                                </div>
                            </div>
                        </div>


                    </c:forEach>



                </div>


            </c:otherwise>
        </c:choose>
		<br>
		<script src='<c:url value="/js/userList.js"/>'></script>
        <c:import url="./includes/footer.jsp" />