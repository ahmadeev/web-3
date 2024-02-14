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

/*    document.querySelector('.slider_input').value = lastR

    let percentsToPut = (lastR - 1) / 3 * 100

    document.querySelector('.slider div').setAttribute("style", 'width: ' + percentsToPut + '%;')
    document.querySelector('.slider span').setAttribute("style", 'left: ' + percentsToPut + '%;')*/

    drawDots(lastR)
    redrawLabels(lastR)


};