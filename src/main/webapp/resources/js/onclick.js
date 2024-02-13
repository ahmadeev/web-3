setTimeout(function(){}, 500)

let svg = document.querySelector('svg')
const div = document.querySelector("#leftContent")
const offsetLeft = div.offsetLeft
const offsetTop = div.offsetTop
svg.addEventListener('click', (event) => {
    //alert('meow')
    let slider = document.querySelector('.slider > div').getAttribute('style').replace(/^.{7}/, '').replace(/.{2}$/, '')
    let RFromSlider = Math.round(100 + 3 * parseFloat(slider)) / 100
    alert(slider + ', R: ' + RFromSlider)
    /*    let RInput = form.querySelector('input[name="RType"]:checked')
        let isRSet = RInput == null ? false : true
        if (isRSet) {
            let R = parseInt(RInput.value)
            let svgx = ((event.clientX - offsetLeft - 25) - 125) / (80 / R)
            let svgy = ((event.clientY - offsetTop - 25) - 125) / (-80 / R)
            if (yValueCheck(svgy.toString())) {
                var data = {'xType':svgx, 'yType':svgy, 'RType':R};
                $.ajax({
                    url: 'controller',
                    method: 'post',
                    dataType: 'html',
                    data: data,
                    success: function(data){
                        return $('body').html(data);
                    }
                });
            } else alert('Значение y должно быть в пределах от -5 до 3!')
        } else alert('Должно быть передано значение R!')*/
})

/*let formLine3 = document.getElementById('rightContent').getElementsByClassName('formLine:nth-child(3)')
alert(formLine3)*/
