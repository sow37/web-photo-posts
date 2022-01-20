<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <c:import url="./includes/header.jsp" />


        <link rel="stylesheet" href='<c:url value="/css/editAccount.css"/>'>

        <div class="container" style="margin-top : 50px;">
            <div class="panel puff-in-center">
                <div class="panel-title fade-in-top" style="text-align: center;">
                    Modifier vos parametres <br/> <i class="fas fa-save fade-in-top"></i> 
                </div>
                <form class="panel-body" action="<c:url value="/user/settings" />" method="post">
                    <div>
                        <span>Login :</span>
                        <input type="password" class="form-control" id="old_password" value="<c:out value="${ form.old_mdp }"/>" name="old_password" placeholder="Votre login...">
                    </div>
                    <div>
                        <span>Mot de passe actuel :</span>
                        <input type="password" class="form-control" id="old_password" value="<c:out value="${ form.old_mdp }"/>" name="old_password" placeholder="Votre mot de passe actuel...">
                    </div>
                    <div>
                        <span>Nouveau mot de passe :</span>
                        <input type="password" class="form-control" id="new_password" value="<c:out value="${ form.mdp }"/>" name="new_password" placeholder="Votre nouveau mot de passe...">
                    </div>
                    <div>
                        <span>Nouveau mot de passe :</span>
                        <input type="password" class="form-control" value="<c:out value="${ form.cmdp }"/>" id="confirm_password" name="confirm_password" placeholder="confirmer votre nouveau mot de passe...">
                    </div>
                    <div style="grid-template-columns : 1fr; margin-top : 15px">
                        <input type="submit" value="Enregistrer">
                    </div>
                </form>
            </div>
        </div>
        <c:import url="./includes/footer.jsp" />