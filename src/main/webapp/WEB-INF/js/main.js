let open = false;
const closeModal = document.querySelector(".modal-close");
const modalBody = document.querySelector(".modal-body");
let currentImage = "";

closeModal.addEventListener("click",(e)=>{
    toggleModal(e);
});


const openModal = event => {

    
    toggleModal();

    
    const link = event.querySelector(".photo").querySelector("img");
    currentImage = link;
    console.log(link.src)
}

const toggleModal = ()=>{
    const modal = document.querySelector(".modal");
    const overlay = document.querySelector(".overlay");
    

    overlay.style.display = "initial";

    open = !open;
    if(open)
    {
        modal.style.top = "50%";
    }
    else
    {
        modal.style.top = "-50%";
        console.log(modal);
    }
}


document.addEventListener("click",(e) => {
    if(e.target !== modalBody && open == true && !e.target.classList.contains("image"))
    {
        toggleModal();
    }
    

})