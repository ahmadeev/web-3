let submit = document.querySelector('input[type="submit"]')
submit.addEventListener("click", function() {
    setTimeout(function() {
        let result = document.getElementById("output").innerHTML
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
    dot.setAttributeNS(null, 'style', 'fill: white; stroke: black;');
    svg.appendChild(dot);
}