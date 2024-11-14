let submit = document.querySelector('.form_submit_button')
submit.addEventListener("click", function() {
    let xInput = parseFloat(document.querySelector('#form_x_container input[type="hidden"]').value)
    let yInput = parseFloat(document.querySelector('.form_input_y').value)
    let RInput = parseFloat(document.querySelector('.slider_input').value)

    if (isValid(xInput, yInput, RInput)) {
        observer.observe(document.querySelector('#centerContent'), {
            childList : true,
            subtree: true
        })
    } else alert('Coordinates are not valid!' + ' (x: ' + xInput.toFixed(2) + ', y: ' + yInput.toFixed(2) + ', R: ' + RInput.toFixed(2) + ')')
})

const ZERO_TO_R_OFFSET = 80
const SVG_SIZE_PARAMETER = 250

function drawDot(x, y, R, isHit, isEqual) {
    let svg = document.querySelector('svg')
    x += ZERO_TO_R_OFFSET * x / R + (SVG_SIZE_PARAMETER / 2)
    y += -ZERO_TO_R_OFFSET * y / R + (SVG_SIZE_PARAMETER / 2)

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
    const empty_message = document.querySelector("tbody tr.ui-datatable-empty-message")
    const rows = document.querySelectorAll('tbody tr')

    const is_empty = empty_message !== null || rows.length === 0
    if (is_empty) return;

    rows.forEach((row) => {
        if (row != null) {
            let cells = row.querySelectorAll('td');
            let REqualsLastR = parseFloat(cells[2].innerText) === lastR;
            drawDot(parseFloat(cells[0].innerText), parseFloat(cells[1].innerText), lastR, (cells[3].innerText === 'true'), REqualsLastR)
        }
    })
}

let reset = document.querySelector('.form_reset_button')
reset.addEventListener("click", resetButton)

function clearDots() {
    const dots = document.querySelectorAll('.target-dot');
    dots.forEach(dot => {dot.remove()})
}

function resetButton() {
    clearDots()

    const rows = document.querySelectorAll('tbody tr');
    rows.forEach(row => {row.remove()})

    for(let i = 0; i < 2; i++) {
        neg_R[i].childNodes[0].nodeValue = '-2.0'
        neg_half_R[i].childNodes[0].nodeValue = '-1.0'
        pos_R[i].childNodes[0].nodeValue = '2.0'
        pos_half_R[i].childNodes[0].nodeValue = '1.0'
    }
}
