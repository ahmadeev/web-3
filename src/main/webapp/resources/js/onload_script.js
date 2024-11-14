window.onload = function(){
    let clock = document.getElementById("clock");

    let now = new Date();
    clock.innerHTML = now.toLocaleTimeString();
    window.setInterval(function(){
        let now = new Date();
        clock.innerHTML = now.toLocaleTimeString();
    },13000);

    const slider = document.querySelector('.slider')
    slider.addEventListener("mousedown", recursive)

    //  Отрисовка точек после перезагрузки
    //  Изменение подписей на графике
    try {
        let rows = document.querySelectorAll('tbody tr')
        let lastR = (rows[rows.length - 1].querySelectorAll('td'))[2].innerText

        redrawLabels(lastR)
        drawDots(parseFloat(lastR))
    } catch (exception) {
        console.log("Какая-то ошибка, блин: " + exception)
    }
};
