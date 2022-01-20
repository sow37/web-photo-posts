<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="./includes/header.jsp"/>


<link rel="stylesheet" href='<c:url value="/css/signup.css"/>'>
<div class="container">
    <div class="login-form fade-in-fwd" style="height : 450px !important">
        <div class="left">
            <div class="text-box">
                <div class="text-box-content">
                    Hello world
                </div>
            </div>
            <div class="left-image" style="background-image : url('<c:url value="/assests/866-1920x1080-blur_2.jpg"/>')">

            </div>
        </div>
        <div class="right">
            <form class="right-container" action="<c:url value="/login" />" method="post">
                <div class="top-right-text">
                    <div>
                        Dont have an account ? <a href="<c:url value="/register"/>">Sign up</a>
                    </div>
                </div>
                <div style="font-size: 40px; font-weight: bold;">
                    Welcome to PhotoApp !
                </div>
                <div style="color: rgb(83, 83, 83); padding-left: 10px;">
                    Connectez vous
                </div>
                <div class="form-input">
                    <span>Login</span>
                    <br>
                    <input type="text" name="login" id="" placeholder="Email">
                </div>
                <div class="form-input">
                    <span>Mot de passe</span>
                    <br>
                    <input type="text" name="password" id="" placeholder="Mot de passe*">
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
	<c:if test="${ !empty param.error }">
	window.addEventListener("DOMContentLoaded",(event) => {
	    showMessage("<c:out value="Verifier vos coordonnees svp"/>");
	});
	</c:if>
</script>

<c:import url="./includes/footer.jsp"/>