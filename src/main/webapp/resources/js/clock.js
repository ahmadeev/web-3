window.onload = function(){

    let now = new Date();
    let clock = document.getElementById("clock");
    clock.innerHTML = now.toLocaleTimeString();
    window.setInterval(function(){
        let now = new Date();
        clock.innerHTML = now.toLocaleTimeString();
    },12000);

    const slider = document.querySelector('.slider')
    slider.addEventListener("mousedown", recursive)

    //  Отрисовка точек после перезагрузки
    //  Изменение подписей на графике
    try {
        let rows = document.querySelectorAll('tbody tr')
        let lastR = (rows[rows.length - 1].querySelectorAll('td'))[2].innerText

        redrawLabels(lastR)
        drawDots(parseFloat(lastR))
    } finally {}
};