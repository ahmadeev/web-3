setTimeout(function(){}, 750)

let submit = document.querySelector('input[type="submit"]')
submit.addEventListener("click", function() {
    const rows = document.querySelectorAll('tbody tr')
    const cells = rows[rows.length - 1].querySelectorAll('td')
    drawDot(parseFloat(cells[0].innerHTML), parseFloat(cells[1].innerHTML), parseFloat(cells[2].innerHTML), (cells[3].innerHTML == 'true' ? true : false), true)
    //alert('' + parseFloat(cells[0].innerHTML) + parseFloat(cells[1].innerHTML) + parseFloat(cells[2].innerHTML) + cells[3].innerHTML)
})

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
        svg1[i].childNodes[0].nodeValue = '-R'
        svg2[i].childNodes[0].nodeValue = '-R/2'
        svg3[i].childNodes[0].nodeValue = 'R'
        svg4[i].childNodes[0].nodeValue = 'R/2'
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
