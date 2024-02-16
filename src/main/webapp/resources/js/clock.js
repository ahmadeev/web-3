window.onload = function(){

    let now = new Date();
    let clock = document.getElementById("clock");
    clock.innerHTML = now.toLocaleTimeString();
    window.setInterval(function(){
        let now = new Date();
        clock.innerHTML = now.toLocaleTimeString();
    },12000);


    //  Отрисовка точек после перезагрузки
    //  Изменение подписей на графике
    let rows = document.querySelectorAll('tbody tr')
    let lastR = (rows[rows.length - 1].querySelectorAll('td'))[2].innerText

    redrawLabels(lastR)
    drawDots(parseFloat(lastR))

    document.querySelector('.slider').addEventListener("mousedown", recursive)

    function recursive() {
        addEventListeners("mousemove touchmove click mouseover mouseout mousedown mouseup", slider)
        document.querySelector('.slider').removeEventListener("mousedown", recursive)
    }
};