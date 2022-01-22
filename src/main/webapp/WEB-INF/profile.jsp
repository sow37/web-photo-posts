<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="./includes/header.jsp"/>


<link rel="stylesheet" href='<c:url value="/css/profile.css"/>'>
<div class="container">
    <div class="id-card-body roll-in-blurred-top ">
        <div class="bar-top"></div>
        <div class="circle">
            
        </div>
        <div class="profile-image">
            <div>
                <i class="far fa-user"></i>
            </div>
        </div>
        <div class="info">
            <div>
                <h1 style="font-size: 14px">${ sessionScope.utilisateur.nom } ${ sessionScope.utilisateur.prenom }</h1>
            </div>
            <div>
                <h4>${ sessionScope.utilisateur.email }</h4>
            </div>
            <div>
                <h5>${ sessionScope.utilisateur.compte.login }</h5>
            </div>
            

        </div>
    </div>
</div>
<script>
    window.addEventListener("DOMContentLoaded",(event) => {
        showMessage("Hello World");
    });
</script>

<c:import url="./includes/footer.jsp"/>