<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/includes/header.jsp"/>
<link rel="stylesheet" href='<c:url value="/css/Home.css"/>'>
<div class="particle-body" id="particles-js">
    <div class="header-text">
        PHOTOGRAM
    </div>
    <div class="sub-text">
        Parceque vos souvenirs sont immortels !
    </div>

    <a href="<c:url value="/register" />" class="main-link">
        Creer Votre Compte!
    </a>
</div>
<div class="showcase" style="padding-bottom: 50px;">
    <div>
    <br>
        <div class="card-image" style="widh: 400px; height: 400px;">

        </div>
    </div>
    <div class="right">
        <div class="right-big-text">
            Partagez 
        </div>
        <div class="grey-text">
            vos plus beaux souvenirs avec vos amis et proches
            <a href="<c:url value="/register" />">ici <i class="fas fa-angle-right"></i></a>
        </div>
        
    </div>
</div>
<div class="showcase-vertical">
    <div class="top">
        <div style="font-size: 50pt; color: red;">
            <i class="fas fa-heart"></i>
        </div>
        <div class="right-big-text">
            Nous gardons vos photos
        </div>
        <div class="right-big-text" style="font-size: 13pt; margin-top: 30px;">
        Vous pouvez 
        </div>
    </div>
    <div class="bottom">
        <div class="card" style="widh: 20px; height: 110px;">
            <div class="card-icon">
                <img src='<c:url value="/assests/book.png"/>' alt="" class="card-icon">
            </div>
            <div class="card-text">
                Partager
            </div>
        </div>
        <div class="card" style="widh: 20px; height: 110px;">
            <div class="card-icon">
                <img src='<c:url value="/assests/picture.png"/>' alt="" class="card-icon">
            </div>
            <div class="card-text">
                Editer
            </div>
        </div>
        <div class="card" style="widh: 20px; height: 110px;">
            <div class="card-icon">
                <img src='<c:url value="/assests/browsing.png"/>' alt="" class="card-icon">
            </div>
            <div class="card-text">
                Supprimer
            </div>
        </div>
    </div>
</div>
<div class="showcase">

</div>
</body>
<script  src='<c:url value="/js/particles.js-master/particles.js"/>'></script>
<script>
/* particlesJS.load(@dom-id, @path-json, @callback (optional)); */
particlesJS.load('particles-js', './js/particles.json', function() {
console.log('callback - particles.js config loaded');
});

</script>

<script>
let oldPosition = 0;
let cardImage = document.querySelector(".card-image");
setInterval(()=>{
    oldPosition = window.pageYOffset;
},500);
window.addEventListener("scroll",(event) => {
    let scrollDown = window.pageYOffset > oldPosition;
    console.log(scrollDown);
    if(scrollDown)
    {
        cardImage.classList.add("goUp");
        cardImage.classList.remove("goDown");
    }
    else 
    {
        cardImage.classList.remove("goUp");
        cardImage.classList.add("goDown");
    }
    
})
</script>
<script>
	<c:if test="${ !empty sessionScope.utilisateur }">
	window.addEventListener("DOMContentLoaded",(event) => {
	    showMessage("<c:out value="Hello, welcome back ${ utilisateur.nom }"/>");
	});
	</c:if>
</script>
<c:import url="/WEB-INF/includes/footer.jsp"/>