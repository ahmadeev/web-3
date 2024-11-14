AVAILABLE_X = [-2, -1.5, -1, -0.5, 0, 0.5]
AVAILABLE_R = [2.0, 2.25, 2.5, 2.75, 3.0, 3.25, 3.5, 3.75, 4.0, 4.25, 4.5, 4.75, 5.0]
Y_MIN = -3
Y_MAX = 5

function isValid(x, y, r) {
    return isXValid(x) && isYValid(y) && isRValid(r)
}

function isXValid(x) {
    return AVAILABLE_X.includes(x);
}

function isRValid(r) {
    return AVAILABLE_R.includes(r);
}

function isYValid(y) {
    return y > Y_MIN && y < Y_MAX;
}
