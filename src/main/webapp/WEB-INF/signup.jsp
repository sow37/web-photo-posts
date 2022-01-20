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
                    Hello world
                </div>
            </div>
            <div class="left-image" style="background-image : url('<c:url value="/assests/866-1920x1080-blur_2.jpg"/>')">

            </div>
        </div>
        <div class="right">
            <form class="right-container" action="<c:url value='${ empty param.user? "/register": "/user/edit" }' />" method="post">
                <div class="top-right-text">
                    <div>
                        Already have an account ? <a href="<c:url value="/login"/>">Sign in</a>
                    </div>
                </div>
                <div style="font-size: 40px; font-weight: bold;">
                    Welcome to PhotoApp !
                </div>
                <div style="color: rgb(83, 83, 83); padding-left: 10px;">
                    Creer votre compte
                </div>
                <div class="form-input">
                    <span>Nom</span>
                    <br>
                    <input type="hidden" class="form-control" name="userId" value="<c:out value="${ form.userId }"/>">
                    <input type="text" class="form-control" id="nom" name="nom" value="<c:out value="${ form.nom }"/>" placeholder="Votre nom...">
                </div>
                <div class="form-input">
                    <span>Prenom</span>
                    <br>
                    <input type="text" class="form-control" id="prenom" name="prenom" value="<c:out value="${ form.prenom }"/>" placeholder="Votre prenom...">
                </div>
                <div class="form-input">
                    <span>Email</span>
                    <br>
                    <input type="email" class="form-control" name="email" value="<c:out value="${ form.email }"/>" id="email" placeholder="Votre adresse email...">
                </div>
                <div class="form-input">
                    <span>Login</span>
                    <br>
                    <input type="text" class="form-control" value="<c:out value="${ form.login }"/>" id="login" name="login" placeholder="Votre login ou nom d'utilisateur...">
                </div>
                <div class="form-input">
                    <span>Password</span>
                    <br>
                    <input type="password" class="form-control" id="password" value="<c:out value="${ form.password }"/>" name="password" placeholder="Votre mot de passe...">
                </div>
                <div class="form-input">
                    <span>Confirmer Password</span>
                    <br>
                    <input type="password" class="form-control" value="<c:out value="${ form.passwordbis }"/>" id="passwordbis" name="passwordbis" placeholder="confirmer votre mot de passe...">
                </div>
                <div class="form-input submit-btn">
                    <input type="submit" value="Sinscrire">
                </div>
            </form>
        </div>
    </div>
</div>




<c:import url="/WEB-INF/includes/footer.jsp"/>