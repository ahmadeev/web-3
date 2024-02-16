const neg_R = document.querySelectorAll('.min_R')
const neg_half_R = document.querySelectorAll('.min_half_R')
const pos_R = document.querySelectorAll('.R')
const pos_half_R = document.querySelectorAll('.half_R')

const slider = document.querySelector('.slider')
const RInput = document.querySelector('.slider_input')

function addEventListeners(types, element) {
    try {
        types.split(" ").forEach(function(e){
            element.addEventListener(e, function () {
                redrawLabels(RInput.value)
                clearDots()
                drawDots(parseFloat(RInput.value))
            });
        })
        return 0
    }
    finally {return 1}
}

function redrawLabels(r) {
    if (parseFloat(r) == 0 || r == null) {return}
    for(let i=0; i<2; i++) {
        neg_R[i].childNodes[0].nodeValue = "-" + r
        pos_R[i].childNodes[0].nodeValue = r
        r = parseFloat(r)
        neg_half_R[i].childNodes[0].nodeValue = "-" + (r / 2).toString()
        pos_half_R[i].childNodes[0].nodeValue = (r / 2).toString()
    }
}
