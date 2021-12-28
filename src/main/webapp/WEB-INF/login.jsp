<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="./Includes/header.jsp"/>


<div style="text-align: center; font-size: 40px;">
    CONNECTEZ VOUS
</div>
<div class="scontainer">
    <div class="cleft affiche">
        <img src="https://picsum.photos/600/800" alt="" class="sign-up-image">
        <div class="text-affiche">
            SOME COOL SHIT
        </div>
    </div>
    <div class="cright">
        <form action="<c:url value="/login" />" method="post">
            <input type="text" name="login" id="" placeholder="Email">
            <input type="text" name="password" id="" placeholder="Mot de passe*">
            <input type="submit" value="Se Connecter">
        </form>
    </div>
</div>



<c:import url="./Includes/footer.jsp"/>