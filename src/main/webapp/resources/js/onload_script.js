//----------------------------------------тут задаются треугольник и четырехугольник
let polygon_points = {
    1: form_polygon_string([
        `${CENTER}, ${CENTER}`,
        `${X_R}, ${CENTER}`,
        `${X_R}, ${Y_R}`,
        `${CENTER}, ${Y_R}`

    ]),
    4: form_polygon_string([
        `${CENTER}, ${CENTER}`,
        `${CENTER}, ${Y_MINUS_R}`,
        `${X_HALF_R}, ${CENTER}`,
    ]),
}

//----------------------------------------тут задается четверть круга
let path_points = {
    2: form_path_string({
        "L"     : `${CENTER}, ${Y_R}`,
        "A"     : `${R}, ${R}`,
        "ANGLE" : "0",
        "END"   : `${X_MINUS_R}, ${CENTER}`
    }),
}

window.onload = async function(){
    //  Навешиваем слушатели событий на слайдер
    const slider = document.querySelector('.slider')
    slider.addEventListener("mousedown", recursive)

    //  Отрисовка точек после перезагрузки
    //  Изменение подписей на графике
    try {
        const svg = document.querySelector('svg')
        await draw_graph(svg, polygon_points, path_points)

        neg_R = document.querySelectorAll('.min_R')
        neg_half_R = document.querySelectorAll('.min_half_R')
        pos_R = document.querySelectorAll('.R')
        pos_half_R = document.querySelectorAll('.half_R')

        let rows = document.querySelectorAll('tbody tr')
        let lastR = (rows[rows.length - 1].querySelectorAll('td'))[2].innerText
        redrawLabels(lastR)
        drawDots(parseFloat(lastR))
    } catch (exception) {
        console.log("Какая-то ошибка, блин: " + exception)
    }
};
