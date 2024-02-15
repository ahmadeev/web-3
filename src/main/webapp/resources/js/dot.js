let submit = document.querySelector('.form_submit_button')
submit.addEventListener("click", function() {
    //alert('meow')
/*
    let rows = document.querySelectorAll('tbody tr')
    let cells = rows[rows.length - 1].querySelectorAll('td')
    alert('' + parseFloat(cells[0].innerHTML) + ' ' + parseFloat(cells[1].innerHTML) + ' ' +  parseFloat(cells[2].innerHTML))
    drawDot(parseFloat(cells[0].innerHTML), parseFloat(cells[1].innerHTML), parseFloat(cells[2].innerHTML), (cells[3].innerHTML == 'true' ? true : false), true)
*/

/*    let x = document.querySelector(".form_input_x").value
    let y = document.querySelector(".form_input_y").value
    let r = document.querySelector(".slider_input").value
    if (isValid(x, y, r)) drawDot(x, y, r, isInside(x, y, r), true)*/

    const RInput = document.querySelector('.slider_input')
    clearDots()
    drawDots(parseFloat(RInput.value))
})

let reset = document.querySelector('.form_reset_button')
reset.addEventListener("click", resetButton)

function drawDot(x, y, R, isHit, isEqual) {
    let svg = document.querySelector('svg')
    x += 80 * x / R + 125
    y += -80 * y / R + 125

    const dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle')
    dot.setAttributeNS(null, 'cx', x);
    dot.setAttributeNS(null, 'cy', y);
    dot.setAttributeNS(null, 'class', "target-dot");
    dot.setAttributeNS(null, 'r', 3);

    let dotColor = isHit ? 'fill: green; stroke: black;' : 'fill: red; stroke: black;'
    dotColor = isEqual ? dotColor : 'fill: white; stroke: black;'

    dot.setAttributeNS(null, 'style', dotColor);
    svg.appendChild(dot);
}

function drawDots(lastR) {
    const rows = document.querySelectorAll('tbody tr')
    rows.forEach((row) => {
        if (row != null) {
            var cells = row.querySelectorAll('td')
            var REqualsLastR = parseFloat(cells[2].innerText) == lastR ? true : false
            drawDot(parseFloat(cells[0].innerText), parseFloat(cells[1].innerText), lastR, (cells[3].innerText == 'true' ? true : false), REqualsLastR)
        }
    })
}

function resetButton() {

    clearDots()

    const rows = document.querySelectorAll('tbody tr');
    rows.forEach(row => {row.remove()})

    for(let i=0; i<2; i++) {
        neg_R[i].childNodes[0].nodeValue = '-R'
        neg_half_R[i].childNodes[0].nodeValue = '-R/2'
        pos_R[i].childNodes[0].nodeValue = 'R'
        pos_half_R[i].childNodes[0].nodeValue = 'R/2'
    }

}

function clearDots() {
    const dots = document.querySelectorAll('.target-dot');
    dots.forEach(dot => {dot.remove()})
}

function sayMeow() {

    let audio = new Audio(); // Создаём новый элемент Audio
    audio.src = 'resources/audio/meow.mp3'; // Указываем путь к звуку "клика"
    audio.autoplay = true; // Автоматически запускаем

}

// let meow = document.querySelector('.meowButton')
