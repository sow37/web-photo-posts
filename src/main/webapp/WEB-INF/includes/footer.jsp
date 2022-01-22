<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="space">
<footer>
            <div class="footer-body">
                <div class="footer-top">
                    <div class="footer-columns">
                       <br> <br><br><div class="logo" onClick="showMessage('Bienvenue')">
                    <a href='<c:url value="/"/>'>PHOTOGRAM</a>
                </div>
                    </div>
                    <div class="footer-columns">
                        <div style="font-weight: bold;">Founders</div><hr style="width:20%;">
                        <div>Elhadji Ousmane</div>
                        <div>Ousmane Sow</div>
                        <div>Demba Diack</div><hr style="width:20%;">
                    </div>
                    <div class="footer-columns">
                        <div style="font-weight: bold;">Github Contact</div><hr style="width:20%;">
                        <div><a href="https://github.com/ousmane12" target="_blank"><i class="fab fa-github"></i></a></div>
                        <div><a href="https://github.com/sow37" target="_blank"><i class="fab fa-github"></i></a></div>
                        <div><a href="https://github.com/DembaDiack" target="_blank"><i class="fab fa-github"></i></a></div>
                        <hr style="width:20%;">
                    </div>
                </div>
                <div class="footer-bottom">
                    <div>
                        
                    </div>
                    <div>
                        Copyright&copy;photgramGLSI2022
                    </div>
                    
                </div>
            </div>
        </footer>
        </div>
<script src="<c:url value='/js/main.js'/>"></script>
<script src="<c:url value='/js/message.js'/>"></script>
<script src="<c:url value='/js/modal.js'/>"></script>
</body>
</html>