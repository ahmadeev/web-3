window.addEventListener("load", () => {
    //  Часы в шапке страницы
    let clock = document.getElementById("clock");
    let now = new Date();
    clock.innerHTML = now.toLocaleTimeString();
    window.setInterval(function(){
        let now = new Date();
        clock.innerHTML = now.toLocaleTimeString();
    },13000);
})