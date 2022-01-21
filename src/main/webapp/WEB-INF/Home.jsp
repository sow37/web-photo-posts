<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/includes/header.jsp"/>
<link rel="stylesheet" href='<c:url value="/css/Home.css"/>'>
<div class="particle-body" id="particles-js">
    <div class="header-text">
        PHOTOESP
    </div>
    <div class="sub-text">
        Some really cool catchphrase
    </div>

    <a href="#" class="main-link">
        Creer Votre Compte!
    </a>
</div>
<div class="showcase" style="padding-bottom: 30px;">
    <div>
        <div class="card-image">

        </div>
    </div>
    <div class="right">
        <div class="right-big-text">
            Quel est donne
        </div>
        <div class="grey-text">
            this is where you write some random cool shit to waste time and shit
            <br>
            use line breaks so it looks like even cooler shit then maybe a 
            <a href="#">random link <i class="fas fa-angle-right"></i></a>
        </div>
        <div class="right-big-text" style="font-size: 40pt;">
            Some even cooler bullshit
        </div>
        <div class="grey-text">
            this is super great stuff and we like it 
        </div>
    </div>
</div>
<div class="showcase-vertical">
    <div class="top">
        <div style="font-size: 15pt; color: rgb(0, 132, 255);">
            this is some small cool shit
        </div>
        <div class="right-big-text">
            This is Centered Shit
        </div>
        <div class="grey-text" style="margin-top: 15px;">
            this is super great stuff and we like it 
        </div>
        <div class="right-big-text" style="font-size: 13pt; margin-top: 30px;">
            Templates are for noobs
        </div>
    </div>
    <div class="bottom">
        <div class="card">
            <div class="card-icon">
                <img src='<c:url value="/assests/book.png"/>' alt="" class="card-icon">
            </div>
            <div class="card-text">
                Some random text shit
            </div>
        </div>
        <div class="card">
            <div class="card-icon">
                <img src='<c:url value="/assests/picture.png"/>' alt="" class="card-icon">
            </div>
            <div class="card-text">
                Some cool text shit
            </div>
        </div>
        <div class="card">
            <div class="card-icon">
                <img src='<c:url value="/assests/browsing.png"/>' alt="" class="card-icon">
            </div>
            <div class="card-text">
                Some cool text shit
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

<c:import url="/WEB-INF/includes/footer.jsp"/>