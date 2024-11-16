//  слушаем клики на свг: проверяем наличие R и отправляем запрос в случае успеха
//  на изменение в дереве #centerContent добавляем точку из n (по количеству отмеченных checkbox) последних строк таблицы
let svg = document.querySelector('svg')
let observer = new MutationObserver(function() {
    let xInput = document.querySelectorAll('div#form_x_container input[type="checkbox"]:checked')
    drawDotsFromLastNRows(xInput.length);
})
// используем константы из submit_and_reset_buttons_handler.js
svg.addEventListener('click', (event) => {
    console.log("Клик на область графика!")
    observer.observe(document.querySelector('#centerContent'), {
        childList : true,
        subtree: true
    })

    let div = document.querySelector("#leftContent")
    let offsetLeft = div.offsetLeft
    let offsetTop = div.offsetTop

    let xInput = null
    let yInput = null
    let RInput = parseFloat(document.querySelector('.slider_input').value)

    if (RInput !== 0 && RInput != null) {
        let someXOffset = 25
        let someYOffset = 25
        xInput = ((event.clientX - offsetLeft - someXOffset) - SVG_SIZE_PARAMETER / 2) / (ZERO_TO_R_OFFSET / RInput)
        yInput = ((event.clientY - offsetTop - someYOffset) - SVG_SIZE_PARAMETER / 2) / (-ZERO_TO_R_OFFSET / RInput)
        if (isYValid(yInput) && isRValid(RInput)) {
            console.log("Переданные значения валидны")
            document.querySelector('.input_x').value = xInput
            document.querySelector('.input_y').value = yInput
            document.querySelector('.input_r').value = RInput
            document.querySelector('.button-hidden').click()
            console.log("Запрос был отправлен!")
        } else alert('Coordinates are not valid!' + ' (x: ' + xInput.toFixed(2) + ', y: ' + yInput.toFixed(2) + ', R: ' + RInput.toFixed(2) + ')')
    } else alert('R is not set!')
})

function drawDotFromLastRow() {
    let rows = document.querySelectorAll('tbody tr')
    let cells = rows[rows.length - 1].querySelectorAll('td')

    let x = parseFloat(cells[0].innerHTML)
    let y = parseFloat(cells[1].innerHTML)
    let r = parseFloat(cells[2].innerHTML)
    let isHit = cells[3].innerHTML === 'true'

    drawDot(x, y, r, isHit, true)
}

function drawDotsFromLastNRows(number) {
    let rows = document.querySelectorAll('tbody tr')

    if (number > rows.length) {
        console.log("Запрос на отрисовку точек количеством больше, чем количество строк")
        return;
    }

    for (let counter = 0; counter < number; counter++) {
        let cells = rows[rows.length - 1 - counter].querySelectorAll('td')

        let x = parseFloat(cells[0].innerHTML)
        let y = parseFloat(cells[1].innerHTML)
        let r = parseFloat(cells[2].innerHTML)
        let isHit = cells[3].innerHTML === 'true'

        drawDot(x, y, r, isHit, true)
    }
}
