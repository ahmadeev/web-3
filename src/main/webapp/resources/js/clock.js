window.onload = function(){
    let now = new Date();
    let clock = document.getElementById("clock");
    clock.innerHTML = now.toLocaleTimeString();
    window.setInterval(function(){
        let now = new Date();
        clock.innerHTML = now.toLocaleTimeString();
    },12000);


    //  Отрисовка точек после перезагрузки
    drawDots()

};