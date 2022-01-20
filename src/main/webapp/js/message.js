const showMessage = msg => {
    console.log(msg);
    const message = document.querySelector(".message");
    const messageContainer = document.querySelector(".message-container");
    message.innerHTML = msg;
    messageContainer.classList.add("message-show");
    setTimeout(() => {
        messageContainer.classList.remove("message-show");
    }, 4000);
}
