function isInside(x, y, r) {
    // 2nd
    if ((y >= 0) && (x <= 0)) return (y <= r / 2) && (x >= -r)
    // 3rd
    if ((y < 0) && (x <= 0)) return (x * x + y * y <= r * r)
    // 4th
    if ((y <= 0) && (x > 0)) return (y >= x - r)
    // 1st
    return false
}