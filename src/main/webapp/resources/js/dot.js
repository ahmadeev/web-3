let submit = document.querySelector('input[type="submit"]')
submit.addEventListener("click", function() {
    setTimeout(function() {
        let result = document.getElementById("output").value
        if (result != "validation error") {
            let json_result = JSON.parse(result)
            drawDot(json_result.x, json_result.y, json_result.R, json_result.isHit)
        } else (alert('validation error'))
    }, 200)

})

//alert('meow')

/*let RInput = document.querySelector('input[type="text"]:nth-child(1)')
RInput.oninput = function() {alert(RInput.innerHTML)}*/



function drawDot(x, y, R, isHit) {
    let svg = document.querySelector('svg')
    x += 80 * x / R + 125
    y += -80 * y / R + 125

    const dot = document.createElementNS("http://www.w3.org/2000/svg", 'circle')
    dot.setAttributeNS(null, 'cx', x);
    dot.setAttributeNS(null, 'cy', y);
    dot.setAttributeNS(null, 'class', "target-dot");
    dot.setAttributeNS(null, 'r', 3);

    if (isHit) {
        var dotColor = 'fill: green; stroke: black;'
    } else {
        var dotColor = 'fill: red; stroke: black;'
    }


    dot.setAttributeNS(null, 'style', dotColor);
    svg.appendChild(dot);
}

function drawDots() {
    const rows = document.querySelectorAll('tbody tr')
    rows.forEach((row) => {
        if (row != null) {
            var cells = row.querySelectorAll('td')
            //alert(cells[2].innerHTML) // R
            drawDot(parseFloat(cells[0].innerText), parseFloat(cells[1].innerText), parseFloat(cells[2].innerText), (cells[3].innerText == 'true' ? true : false))
        }
    })
}

function resetButton() {

    const dots = document.querySelectorAll('.target-dot');
    dots.forEach(dot => {dot.remove()})

    const rows = document.querySelectorAll('tbody tr');
    rows.forEach(row => {row.remove()})

}

function sayMeow() {

    let audio = new Audio(); // Создаём новый элемент Audio
    audio.src = 'resources/audio/meow.mp3'; // Указываем путь к звуку "клика"
    audio.autoplay = true; // Автоматически запускаем

}