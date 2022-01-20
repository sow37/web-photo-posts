<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
    <html>
    <head>
        <link rel="stylesheet" href="<c:url value='/css/animations.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/main.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/modal.css'/>">
        <link rel="stylesheet" href="<c:url value='/css/album.css'/>">
        <link rel="stylesheet" href="<c:url value='/fonts/stylesheet.css'/>">
    	<link rel="stylesheet" href='<c:url value="/fontawesome-free-5.15.4-web/css/all.css"/>'>
    </head>
    <body>
     <div class="modal">
            <div class="modal-body">
                <div class="modal-box">
                    <div class="modal-box-body">
                        <i class="modal-close far fa-times-circle" onclick="hideModal()" ></i>
                        <div class="modal-image">
                            <img class="modal-image-src" src="" alt="">
                        </div>
                        <div class="info">
                            <table>
                                <tr>
                                  <th>id</th>
                                  <th>titre</th>
                                  <th>proprio</th>
                                  <th>description</th>
                                  <th>taille</th>
                                  <th>creation</th>
                                  <th>Voir</th>
                                </tr>
                                <tr>
                                  <td class="modal-album-id"></td>
                                  <td class="modal-album-titre"></td>
                                  <td class="modal-album-owner"></td>
                                  <td class="modal-album-description"></td>
                                  <td class="modal-album-size"></td>
                                  <td class="modal-album-creation"></td>
                                  <td class="modal-album-link"></td>
                                </tr>
                              </table>
                        </div>
                    </div>
                </div>
            </div> 
        </div>

        <div class="menu">
            <div class="submenu"></div>
            <div class="subsubmenu"></div>
            <div class="body">
                <div class="close-button">
                    CLOSE
                </div>
                <div class="menu-items">
                <c:if test="${!empty sessionScope.utilisateur }">
                <div class="item">
                        <a href='<c:url value="/user/albums"/>'>Ma gallerie</a>
                        <hr>
                    </div>
                </c:if>
                    <c:if test="${!empty sessionScope.utilisateur }">
	                    <div class="item item-dropdown">
	                        <div class="title">
	                            <c:out value="${utilisateur.nom }"/>
	                        </div>
	                        <div class="list">
	                           <div><a href='<c:url value="/user/profile"/>'>Mon profil</a></div>
	                           <div><a href='<c:url value="/user/settings"/>'>Modifier profil</a></div>
	                           <div><a href='<c:url value="/logout"/>'>Deconnecter</a></div>
	                        </div>
	                    </div>
                    </c:if>
                    
                </div>
            </div>
        </div>
        <nav>
            <div class="left">
                <div class="hamburger-menu">
                    <div class="bar one"></div>
                    <div class="bar two"></div>
                    <div class="bar three"></div>
                    
                </div>
                <div class="logo" onClick="showMessage('Bienvenue')">
                    <a href='<c:url value="/"/>'>PHOTOAPP</a>
                </div>
            </div>    
            <div class="right">
            	<div class="nav-link mobile">
                    <a href='<c:url value="/user/albums"/>'>Gallerie</a>
                </div>
                <c:if test="${!empty sessionScope.utilisateur }">
                <div class="nav-link mobile">
                    <a href='<c:url value="/user/albums"/>'>Ma gallerie</a>
                </div>
                </c:if>
                
                
                <c:if test="${ !empty utilisateur.nom}">
             		
             		<div class="nav-link-dropdown mobile">
                    <div class="dropdown">
                        <button class="dropbtn">
                        	Liste Utilisateurs
                        </button>
                        <div class="dropdown-content">
                          <a href='<c:url value="/user/list"/>'>Utilisateurs Simple</a>
                          <a href='<c:url value="/user/list-admin"/>'>Utilisateurs Admin</a>
                        </div>
                      </div>
                </div>
             	</c:if>
                
                <c:if test="${!empty sessionScope.utilisateur }">
                <div class="nav-link-dropdown mobile">
                    <div class="dropdown">
                        <button class="dropbtn">
                        	<c:out value="${utilisateur.nom }"/>
                        </button>
                        <div class="dropdown-content">
                          <a href='<c:url value="/user/profile"/>'><i style="color : #373737; margin-right : 5px" class="fa fa-user"></i>Mon profil </a>
                          <a href='<c:url value="/user/settings"/>'><i style="color : #373737; margin-right : 5px" class="fa fa-cog"></i>Modifier profil</a>
                          <a href='<c:url value="/logout"/>'><i style="color : #373737; margin-right : 5px" class="fa fa-sign-out-alt"></i>Deconnecter</a>
                        </div>
                      </div>
                </div>
                </c:if>
                
                
             	
             	
             	
             	
             	
             	
             	
             	<c:if test="${empty sessionScope.utilisateur }">
	             	<div class="nav-link mobile">
	                    <a href='<c:url value="/login"/>'>Se connecter</a>
	                </div>
             	</c:if>
                
                
            </div>
            
        </nav>