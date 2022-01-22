<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="./includes/header.jsp"/>


<link rel="stylesheet" href='<c:url value="/css/signup.css"/>'>
<div class="container">
    <div class="login-form" style="height : 450px !important">
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
            <form class="right-container" action="<c:url value="/login" />" method="post">
                <div class="top-right-text">
                    <div>
                        Vous n'avez pas de compte ? <a href="<c:url value="/register"/>">Inscription</a>
                    </div>
                </div>
                <div style="font-size: 30px; font-weight: bold;">
                    Content de vous revoir !
                </div>
                <div style="color: rgb(83, 83, 83); padding-left: 10px;">
                    Connectez vous
                </div>
                <br>
                <c:if test="${ param.error == 1 }">
                <span class="titre" style="color: red;">Login ou Mot de passe incorrect </span>
            </c:if>
                <div class="form-input">
                    <span>Login</span>
                    <br>
                    <input type="text" name="login" id="" placeholder="Login..." value="<c:out value="${ param.user }"/>">
                </div>
                <div class="form-input">
                    <span>Mot de passe</span>
                    <br>
                    <input type="password" name="password" id="" placeholder="Mot de passe*">
                </div>
                <div class="form-input submit-btn">
                    <input type="submit" value="Se connecter">
                </div>
            </form>
        </div>
    </div>
</div>
<script>
	<c:if test="${ !empty param.ajout }">
	window.addEventListener("DOMContentLoaded",(event) => {
	    showMessage("<c:out value="${ param.ajout }"/>");
	});
	</c:if>
</script>

<c:import url="./includes/footer.jsp"/>