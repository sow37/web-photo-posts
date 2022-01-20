const closeButton = document.querySelector(".close-button");
const menu = document.querySelector(".menu");
const submenu = document.querySelector(".submenu");
const subsubmenu = document.querySelector(".subsubmenu");
const hamburgerButton = document.querySelector(".hamburger-menu");
const itemDropDownList = document.querySelectorAll(".item-dropdown");
let dropdown = undefined;


const hideMenu = ()=>{
    subsubmenu.classList.remove("subsubmenushow");;
    submenu.classList.remove("submenushow");
    menu.classList.remove("menu-show");
}
const showMenu = ()=> {
    subsubmenu.classList.add("subsubmenushow");;
    submenu.classList.add("submenushow");
    menu.classList.add("menu-show");
}
hamburgerButton.addEventListener("click",(event) => {
    showMenu();
})
closeButton.addEventListener("click",(event) => {
    hideMenu();
})

const dropdownitems = document.querySelectorAll(".nav-link-dropdown");

dropdownitems.forEach(dropdown => {
    console.log(dropdown);
    list = dropdown.querySelector(".dropdown-items");
    dropdown.addEventListener("mouseenter",(event) => {
        list.style.display = "initial";
    })
    dropdown.addEventListener("mouseleave",(event) => {
        setTimeout(()=>{
            
        },1000);
    })
})

itemDropDownList.forEach(item => {
    console.log(item);
    item.addEventListener("click",(event) => {
        console.log(event);
        let list = item.querySelector(".list");
        console.log(list);
        if(list.classList.contains("list-show"))
        {
            list.classList.remove("list-show");
        }
        else
        {
            list.classList.add("list-show");
        }
    })
})
window.addEventListener("click",(event) => {
    if(event.target.nodeName == "BODY" && menu.classList.contains("menu-show"))
    {
       hideMenu();
    }
})

