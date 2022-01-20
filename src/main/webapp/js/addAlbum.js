const droparea = document.querySelector(".dropzone");
if(droparea)
{
    const fileInput = document.querySelector(".upload");

    droparea.addEventListener("dragenter",(e)=>{
        droparea.style.border = "solid black 5px";
    });
    droparea.addEventListener("dragleave",(e)=>{
        droparea.style.border = "dashed black 5px";
    });
    window.addEventListener("dragover",(e)=>{
        e.preventDefault();
    });
    window.addEventListener("drop", function(event) {
        // prevent default action (open as link for some elements)
        event.preventDefault();
        event.stopPropagation();
        droparea.style.border = "dashed black 5px";

        fileInput.files = event.dataTransfer.files;
      }, false);

    
    fileInput.addEventListener("change",event => {
        console.log(event.target.files);
    });

    
}


const select = document.querySelector(".statut");
select.addEventListener("change",(event) => {
	const listeDesUtilisateurs = document.querySelector(".usersAuth");
	if(event.target.value == "prive")
		{
			listeDesUtilisateurs.style.display = "initial";
		}
	else
		{
		listeDesUtilisateurs.style.display = "none";
		}
})