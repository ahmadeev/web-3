setTimeout(function(){}, 750)

let svg = document.querySelector('svg')
const div = document.querySelector("#leftContent")
const offsetLeft = div.offsetLeft
const offsetTop = div.offsetTop
svg.addEventListener('click', (event) => {
    let xInput
    let yInput
    let RInput = parseFloat(document.querySelector('.slider_input').value)
    if (RInput != 0 && RInput != null) {
        xInput = ((event.clientX - offsetLeft - 25) - 125) / (80 / RInput)
        yInput = ((event.clientY - offsetTop - 25) - 125) / (-80 / RInput)
        if (isYValid(yInput) && isRValid(RInput)) {
            alert("x: " + xInput + ", y: " + yInput + ", R: " + RInput + ", Hit: " + (isInside(xInput, yInput, RInput) == true ? 'true' : 'false'))

/*            document.querySelector('.text_input_x').value = xInput
            document.querySelector('.text_input_y').value = yInput
            document.querySelector('.slider_input').value = RInput
            submit.click()*/

        } else alert('Coordinates are not valid!')
    } else alert('R is not set!')
})
