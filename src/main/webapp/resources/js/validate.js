AVAILABLE_X = [-5, -4, -3, -2, -1, 0, 1, 2, 3]
AVAILABLE_R = [1.0, 1.25, 1.5, 1.75, 2.0, 2.25, 2.5, 2.75, 3.0, 3.25, 3.5, 3.75, 4.0]
Y_MIN = -3
Y_MAX = 3

function isValid(x, y, r) {
    return isXValid(x) && isYValid(y) && isRValid(r)
}

function isXValid(x) {
    if (AVAILABLE_X.includes(x)) return true
    else return false
}

function isRValid(r) {
    if (AVAILABLE_R.includes(r)) return true
    else return false
}

function isYValid(y) {
    if (y > Y_MIN && y < Y_MAX) return true
    else return false
}
