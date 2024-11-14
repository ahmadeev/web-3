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

let reset = document.querySelector('.form_reset_button')
reset.addEventListener("click", resetButton)

const zero_to_R_offset = 80
const svg_size_parameter = 250

function drawDot(x, y, R, isHit, isEqual) {
    let svg = document.querySelector('svg')
    x += zero_to_R_offset * x / R + (svg_size_parameter / 2)
    y += -zero_to_R_offset * y / R + (svg_size_parameter / 2)

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
    const is_empty = document.querySelector("tbody tr.ui-datatable-empty-message").length !== 0
    if (is_empty) return;

    const rows = document.querySelectorAll('tbody tr')
    console.log(rows)
    rows.forEach((row) => {
        if (row != null) {
            let cells = row.querySelectorAll('td');
            let REqualsLastR = parseFloat(cells[2].innerText) === lastR;
            drawDot(parseFloat(cells[0].innerText), parseFloat(cells[1].innerText), lastR, (cells[3].innerText === 'true'), REqualsLastR)
        }
    })
}

function resetButton() {
    clearDots()

    const rows = document.querySelectorAll('tbody tr');
    rows.forEach(row => {row.remove()})

/*    for(let i=0; i<2; i++) {
        neg_R[i].childNodes[0].nodeValue = '-R'
        neg_half_R[i].childNodes[0].nodeValue = '-R/2'
        pos_R[i].childNodes[0].nodeValue = 'R'
        pos_half_R[i].childNodes[0].nodeValue = 'R/2'
    }*/

    for(let i = 0; i < 2; i++) {
        neg_R[i].childNodes[0].nodeValue = '-2.0'
        neg_half_R[i].childNodes[0].nodeValue = '-1.0'
        pos_R[i].childNodes[0].nodeValue = '2.0'
        pos_half_R[i].childNodes[0].nodeValue = '1.0'
    }
}

function clearDots() {
    const dots = document.querySelectorAll('.target-dot');
    dots.forEach(dot => {dot.remove()})
}
