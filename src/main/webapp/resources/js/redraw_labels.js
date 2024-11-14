//  функции добавления слушателей событий (множества)

const neg_R = document.querySelectorAll('.min_R')
const neg_half_R = document.querySelectorAll('.min_half_R')
const pos_R = document.querySelectorAll('.R')
const pos_half_R = document.querySelectorAll('.half_R')

//  callback обязательно void
function addEventListeners(types, element, callback) {
    try {
        types.split(" ").forEach(function(e){
            element.addEventListener(e, function () {
                callback();
            });
        })
        return 0
    } catch (exception) {
        return 1
    }
}

function redrawLabels(r) {
    if (parseFloat(r) === 0 || r == null) return;
    for(let i = 0; i < 2; i++) {
        neg_R[i].childNodes[0].nodeValue = "-" + r
        pos_R[i].childNodes[0].nodeValue = r
        r = parseFloat(r)
        neg_half_R[i].childNodes[0].nodeValue = "-" + (r / 2).toString()
        pos_half_R[i].childNodes[0].nodeValue = (r / 2).toString()
    }
}

function recursive() {
    const slider = document.querySelector('.slider')
    addEventListeners("mousemove touchmove click mouseover mouseout mousedown mouseup", slider, () => {
        const RInput = document.querySelector('.slider_input')
        redrawLabels(RInput.value)
        clearDots()
        drawDots(parseFloat(RInput.value))
    })
    slider.removeEventListener("mousedown", recursive)
}
