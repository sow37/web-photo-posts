<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="sn.wpp.common.enumeration.Profil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/includes/header.jsp"/>

<link rel="stylesheet" href='<c:url value="/css/signup.css"/>'>
<div class="container">
    <div class="login-form fade-in-fwd">
        <div class="left">
            <div class="text-box">
                <div class="text-box-content">
                    Un monde de souvenir
                </div>
            </div>
            <div class="left-image" style="background-image : url('<c:url value="/assests/866-1920x1080-blur_2.jpg"/>')">

            </div>
        </div>
        <div class="right">
            <form class="right-container" action="<c:url value='${ empty param.user? "/register": "/user/edit" }' />" method="post">
                <div class="top-right-text">
                    <div>
                        Vous avez un compte ? <a href="<c:url value="/login"/>">Connectez-vous</a>
                    </div>
                </div>
                <div style="font-size: 30px; font-weight: bold;">
                    Bienvenue sur PhotoGram !
                </div>
                <div style="color: rgb(83, 83, 83); padding-left: 10px;">
                    Creez votre compte
                </div>
                <br>
                <c:if test="${ !empty form.statusMessage }">
                <span class="titre" style="color: red; text-align: center;">${ form.statusMessage }</span>
           
            </c:if>
                <div class="form-input">
                    <span>Nom</span>
                    <br>
                    <input type="hidden" class="form-control" name="userId"/>
                    <input type="text" class="form-control" id="nom" name="nom" value='<c:out value="${ form.utilisateur.nom }"/>' placeholder="Votre nom...">
                	<span style="color: red; font-weight: 2px;"><c:out value="${ form.erreurs.nom }"/></span>
                </div>
                <div class="form-input">
                    <span>Prenom</span>
                    <br>
                    <input type="text" class="form-control" id="prenom" name="prenom" value="<c:out value="${ form.utilisateur.prenom }"/>" placeholder="Votre prenom...">
                    <span style="color: red; font-weight: 2px;"><c:out value="${ form.erreurs.prenom }"/></span>
                </div>
                <div class="form-input">
                    <span>Email</span>
                    <br>
                    <input type="email" class="form-control" name="email" value="<c:out value="${ form.utilisateur.email }"/>" id="email" placeholder="Votre adresse email...">
                    <span style="color: red; font-weight: 2px;"><c:out value="${ form.erreurs.email }"/></span>
                </div>
                <div class="form-input">
                    <span>Login</span>
                    <br>
                    <input type="text" class="form-control" value="<c:out value="${ form.utilisateur.compte.login }"/>" id="login" name="login" placeholder="Votre login ou nom d'utilisateur...">
                    <span style="color: red; font-weight: 2px;"><c:out value="${ form.erreurs.login }"/></span>
                </div>
                <div class="form-input">
                    <span>Mot de passe</span>
                    <br>
                    <input type="password" class="form-control" id="password" value="<c:out value="${ form.utilisateur.compte.password }"/>" name="password" placeholder="Votre mot de passe...">
                    <span style="color: red; font-weight: 2px;"><c:out value="${ form.erreurs.password }"/></span>
                </div>
                <div class="form-input">
                    <span>Confirmer Mot de passe</span>
                    <br>
                    <input type="password" class="form-control" id="passwordbis" name="passwordbis" placeholder="confirmer votre mot de passe...">
                    <span style="color: red; font-weight: 2px;">${ form.erreurs.password }</span>
                </div>
                <div class="form-input submit-btn">
                    <input type="submit" value="Sinscrire">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
	<c:if test="${ !empty form.statusMessage }">
	window.addEventListener("DOMContentLoaded",(event) => {
	    showMessage("<c:out value="${ form.statusMessage }"/>");
	});
	</c:if>
</script>



<c:import url="/WEB-INF/includes/footer.jsp"/>