// const closeButton = document.querySelector(".close-button");
// const menu = document.querySelector(".menu");
// const submenu = document.querySelector(".submenu");
// const subsubmenu = document.querySelector(".subsubmenu");
// const hamburgerButton = document.querySelector(".hamburger-menu");
// const itemDropDownList = document.querySelectorAll(".item-dropdown");
// let dropdown = undefined;


// const hideMenu = ()=>{
//     subsubmenu.classList.remove("subsubmenushow");;
//     submenu.classList.remove("submenushow");
//     menu.classList.remove("menu-show");
// }
// const showMenu = ()=> {
//     subsubmenu.classList.add("subsubmenushow");;
//     submenu.classList.add("submenushow");
//     menu.classList.add("menu-show");
// }
// hamburgerButton.addEventListener("click",(event) => {
//     showMenu();
// })
// closeButton.addEventListener("click",(event) => {
//     hideMenu();
// })

// const dropdownitems = document.querySelectorAll(".nav-link-dropdown");

// dropdownitems.forEach(dropdown => {
//     console.log(dropdown);
//     list = dropdown.querySelector(".dropdown-items");
//     dropdown.addEventListener("mouseenter",(event) => {
//         list.style.display = "initial";
//     })
//     dropdown.addEventListener("mouseleave",(event) => {
//         setTimeout(()=>{
            
//         },1000);
//     })
// })

// itemDropDownList.forEach(item => {
//     console.log(item);
//     item.addEventListener("click",(event) => {
//         console.log(event);
//         let list = item.querySelector(".list");
//         console.log(list);
//         if(list.classList.contains("list-show"))
//         {
//             list.classList.remove("list-show");
//         }
//         else
//         {
//             list.classList.add("list-show");
//         }
//     })
// })
// window.addEventListener("click",(event) => {
//     if(event.target.nodeName == "BODY" && menu.classList.contains("menu-show"))
//     {
//        hideMenu();
//     }
// })







const showModal = (source)=>{

    let rawURL = source.querySelector(".album-content").style.backgroundImage;
    let url = rawURL.slice(5,rawURL.length - 2);
    const modal = document.querySelector(".modal");
    const modalImage = document.querySelector(".modal-image-src");
    const albumId = source.querySelector(".album-id").innerText;
    const albumDescription = source.querySelector(".album-description").innerText;
    const albumTitle = source.querySelector(".album-title").innerText;
    const albumSize = source.querySelector(".album-taille").innerText;
    const albumOwner = source.querySelector(".album-proprio").innerText;
    const albumCreation = source.querySelector(".album-date").innerText;
    const albumLink = source.querySelector(".album-link").innerHTML;
    modal.querySelector(".modal-album-id").innerText = albumId;
    modal.querySelector(".modal-album-titre").innerText = albumTitle;
    modal.querySelector(".modal-album-description").innerText = albumDescription;
    modal.querySelector(".modal-album-creation").innerText = albumCreation;
    modal.querySelector(".modal-album-owner").innerText = albumOwner;
    modal.querySelector(".modal-album-size").innerText = albumSize;
    modal.querySelector(".modal-album-link").innerHTML = albumLink;
    modalImage.setAttribute("src",url);
    modal.classList.add("modal-show");
}
const hideModal = ()=>{
    const modal = document.querySelector(".modal");
    modal.classList.remove("modal-show");
}


document.addEventListener("click",event => {
    const modal = document.querySelector(".modal");
    const modalBody = document.querySelector(".modal-body");
    if(event.target == modalBody)
    {
        modal.classList.remove("modal-show"); 
    }
})

const showImageModal = (event) => {
	let source = event.target.parentNode.querySelector(".image-info");
	let rawURL = event.target.style.backgroundImage;
    let url = rawURL.slice(5,rawURL.length - 2);
    const modal = document.querySelector(".modal");   
    const modalImage = document.querySelector(".modal-image-src");
    
    const albumId = source.querySelector(".album-id").innerText;
    const albumDescription = source.querySelector(".album-description").innerText;
    const albumTitle = source.querySelector(".album-title").innerText;
    const albumSize = source.querySelector(".album-taille").innerText;
    const albumOwner = source.querySelector(".album-proprio").innerText;
    const albumCreation = source.querySelector(".album-date").innerText;
    const albumLink = source.querySelector(".album-link").innerHTML;
    modal.querySelector(".modal-album-id").innerText = albumId;
    modal.querySelector(".modal-album-titre").innerText = albumTitle;
    modal.querySelector(".modal-album-description").innerText = albumDescription;
    modal.querySelector(".modal-album-creation").innerText = albumCreation;
    modal.querySelector(".modal-album-owner").innerText = albumOwner;
    modal.querySelector(".modal-album-size").innerText = albumSize;
    modal.querySelector(".modal-album-link").innerHTML = albumLink;
    
    modalImage.setAttribute("src",url);
    modal.classList.add("modal-show");
}