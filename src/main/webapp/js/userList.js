const dropdowns = document.querySelectorAll(".dropdown-icon");
        dropdowns.forEach(function(dropdown){
            dropdown.addEventListener("click",event => {
                let icon = event.target;
                const parent = event.target.parentNode.parentNode;
                let body = parent.querySelector(".user-body");
                if(body.classList.contains("show-body"))
                {
                    icon.classList.add("fa-caret-down");
                    icon.classList.remove("fa-caret-up");
                    body.classList.remove("show-body");
                }
                else{
                    icon.classList.add("fa-caret-up");
                    icon.classList.remove("fa-caret-down");
                    body.classList.add("show-body");
                }
            });
        })