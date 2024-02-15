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

function drawDotFromLastRow() {

    let rows = document.querySelectorAll('tbody tr')
    let cells = rows[rows.length - 1].querySelectorAll('td')

    let x = parseFloat(cells[0].innerHTML)
    let y = parseFloat(cells[1].innerHTML)
    let r = parseFloat(cells[2].innerHTML)
    let isHit = cells[3].innerHTML == 'true' ? true : false

    drawDot(x, y, r, isHit, true)

}
