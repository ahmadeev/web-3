let svg = document.querySelector('svg')

let div = document.querySelector("#leftContent")
let offsetLeft = div.offsetLeft
let offsetTop = div.offsetTop

window.onresize = function(){
    div = document.querySelector("#leftContent")
    offsetLeft = div.offsetLeft
    offsetTop = div.offsetTop
}

let observer = new MutationObserver(function() {drawDotFromLastRow()})

svg.addEventListener('click', (event) => {

    observer.observe(document.querySelector('#centerContent'), {
        childList : true,
        subtree: true
    })

    div = document.querySelector("#leftContent")
    offsetLeft = div.offsetLeft
    offsetTop = div.offsetTop
    let xInput = null
    let yInput = null
    let RInput = parseFloat(document.querySelector('.slider_input').value)
    if (RInput != 0 && RInput != null) {
        // alert(offsetLeft + " " + offsetTop)
        // alert((event.clientX - offsetLeft) + " " + (event.clientY - offsetTop))
        xInput = ((event.clientX - offsetLeft - 25) - 125) / (80 / RInput)
        yInput = ((event.clientY - offsetTop - 25) - 125) / (-80 / RInput)
        // alert(xInput + " " + yInput)
        if (isYValid(yInput) && isRValid(RInput)) {
            document.querySelector('.input_x').value = xInput
            document.querySelector('.input_y').value = yInput
            document.querySelector('.input_r').value = RInput
            document.querySelector('.button-hidden').click()

        } else alert('Coordinates are not valid!' + ' (x: ' + xInput.toFixed(2) + ', y: ' + yInput.toFixed(2) + ', R: ' + RInput.toFixed(2) + ')')
    } else alert('R is not set!')
})

/*let table_rows = document.getElementsByTagName('tr')
let table_rows_length = table_rows.length
let dots = document.getElementsByTagName('circle')
const style_attribute_new = 'fill: #E6D4C3FF; stroke: black;'

for(let i = 1; i < table_rows_length; i++) {
    table_rows[i].addEventListener("click", function() {
        const style_attribute_old = dots.item(i-1).getAttribute('style')
        dots.item(i-1).setAttribute("style", style_attribute_new)
        setTimeout(function() {dots.item(i-1).setAttribute("style", style_attribute_old)}, 1500)
        dots.item(i-1).setAttribute("r", '5')
        setTimeout(function() {dots.item(i-1).setAttribute("r", '3')}, 1500)
    })
}*/

function drawDotFromLastRow() {

    let rows = document.querySelectorAll('tbody tr')
    let cells = rows[rows.length - 1].querySelectorAll('td')

    let x = parseFloat(cells[0].innerHTML)
    let y = parseFloat(cells[1].innerHTML)
    let r = parseFloat(cells[2].innerHTML)
    let isHit = cells[3].innerHTML == 'true' ? true : false

    drawDot(x, y, r, isHit, true)

}
